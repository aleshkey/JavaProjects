package com.my_tg_bot.tg_bot.service;

import com.my_tg_bot.tg_bot.config.BotConfig;
import com.my_tg_bot.tg_bot.model.User;
import com.my_tg_bot.tg_bot.model.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.MessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@PropertySource(value = "application.properties")
public class TgBot extends TelegramLongPollingBot {

    private String url="jdbc:mysql://localhost:3306/tg_bot";

    private String newMessage;

    private  String username="root";

    private String password="23130022";

    private Connection connection;
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager. getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private UserRepository userRepository;

    static final String HELP_TEXT = "This is my first bot";

    final BotConfig config;

    public TgBot(BotConfig config) {
        this.config = config;
        List<BotCommand> listOfCommands = new ArrayList<>();
        listOfCommands.add(new BotCommand("/start", "start bot"));
        listOfCommands.add(new BotCommand("/get_random_joke", "random joke"));
        listOfCommands.add(new BotCommand("/weather", "weather"));
        listOfCommands.add(new BotCommand("/mydata", "show your data"));
        listOfCommands.add(new BotCommand("/deletedata", "delete my data"));
        listOfCommands.add(new BotCommand("/help", "how to use this bot"));
        listOfCommands.add(new BotCommand("/settings", "settings"));
        try {
            this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("error setting bot's command list" + e.getMessage());
        }

    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()){

            String messageText = update.getMessage().getText();
            long chatId=update.getMessage().getChatId();

            if (messageText.charAt(0)=='/') {
                switch (messageText) {

                    case "/start": {
                        registerUser(update.getMessage());
                        break;
                    }

                    case "/help": {
                        sendMessage(chatId, HELP_TEXT);
                        break;
                    }

                    case "/mydata": {
                        showData(update.getMessage());
                        break;
                    }

                    case "/deletedata": {
                        deleteData(update.getMessage());
                        break;
                    }

                    case "/get_random_joke": {
                        sendJoke(update.getMessage());
                        break;
                    }

                    case "/weather": {
                        sendWeather(update);
                        break;
                    }

                    default: {
                        sendMessage(chatId, "sorry, unknown command");
                    }
                }
            }
            else {
                newMessage = messageText;
            }
        }

    }

    private void sendWeather(Update update) {
        String result="";
        String town = "minsk";
        String weather=new String();
        try {
            weather=Parser.searchWeather(town);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sendMessage(update.getMessage().getChatId(), weather);
    }

    private void sendJoke(Message message) {
        int id = (int)(Math.random()*6);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement( "select * from joke_data_base where id= ?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            sendMessage(message.getChatId(), resultSet.getString("joke"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void deleteData(Message message) {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from user_data_table where chat_id=?");
            preparedStatement.setLong(1, message.getChatId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sendMessage(message.getChatId(), "you have delete this bot");
    }

    private void registerUser(Message message) {
        if (userRepository.findById(message.getChatId()).isEmpty()){
            var chatId = message.getChatId();
            var chat = message.getChat();

            var user = new User();

            user.setChatId(chatId);
            user.setFirstName(chat.getFirstName());
            user.setLastName(chat.getLastName());
            user.setUserName(chat.getUserName());
            user.setRegisteredAt(new Timestamp(System.currentTimeMillis()));

            userRepository.save(user);
            startBot(chatId, chat.getFirstName());
            log.info("save user");
        }
        else{
            sendMessage(message.getChatId(), "you've already started this bot");
        }
    }

    private void startBot(long chatId, String name){
        String answer = "Hi, " + name + ", nice to meet you";
        log.info("Replied to user "+name);
        sendMessage(chatId, answer);
    }

    private void sendMessage( long chatId, String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);


        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();

        row.add("weather");
        row.add("/get_random_joke");

        keyboardRows.add(row);

        row = new KeyboardRow();

        row.add("register");
        row.add("check my data");
        row.add("delete my data");

        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);

        message.setReplyMarkup(keyboardMarkup);


        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error occurred: "+e.getMessage());
        }
    }

    private void showData(Message message){

        Optional<User> optionalUser = userRepository.findById(message.getChatId());
        User user = optionalUser.isPresent() ? optionalUser.get() : new User();

        sendMessage(message.getChatId(), "your id: "+user.getChatId()+"\n\nyour first name: " +user.getFirstName()+"\n\nyou've registered at: "+user.getRegisteredAt());

    }
}

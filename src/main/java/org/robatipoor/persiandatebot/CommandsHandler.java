package org.robatipoor.persiandatebot;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

import org.robatipoor.JalaliCalendar;

public class CommandsHandler extends TelegramLongPollingCommandBot {

    public CommandsHandler(String botUsername) {
        super(botUsername);
        this.register(new TodayCommand());
        this.register(new YearCommand());
        this.register(new DayCommand());
        this.register(new DayOfWeekCommand());
        this.register(new TomorrowCommand());
        this.register(new YesterdayCommand());
        this.register(new HelpCommand(this));
        this.register(new MonthCommand());
        this.register(new HolidayCommand());
    }

    @Override
    public void processNonCommandUpdate(Update update) {

    }

    @Override
    public String getBotToken() {
        return System.getenv("TELEGRAM_TOKEN");
    }
}

class StartCommand extends BotCommand {

    public StartCommand() {
        super("start", "persain date");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage msg = new SendMessage();
        System.out.println(chat.getUserName());
        JalaliCalendar today = new JalaliCalendar();
        System.out.println(today.toString());
        msg.setChatId(chat.getId());
        msg.setText(today.toString());
        try {
            absSender.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TodayCommand extends BotCommand {

    public TodayCommand() {
        super("today", "today persain date");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage msg = new SendMessage();
        System.out.println(chat.getUserName());
        JalaliCalendar today = new JalaliCalendar();
        System.out.println(today.toString());
        msg.setChatId(chat.getId());
        msg.setText(today.toString());
        try {
            absSender.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DayCommand extends BotCommand {

    public DayCommand() {
        super("day", "day persain date");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage msg = new SendMessage();
        System.out.println(chat.getUserName());
        JalaliCalendar today = new JalaliCalendar();
        var v = today.getDay();
        System.out.println(v);
        msg.setChatId(chat.getId());
        msg.setText(String.valueOf(v));
        try {
            absSender.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class YearCommand extends BotCommand {

    public YearCommand() {
        super("year", "year persain date");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage msg = new SendMessage();
        System.out.println(chat.getUserName());
        JalaliCalendar today = new JalaliCalendar();
        var v = today.getYear();
        System.out.println(v);
        msg.setChatId(chat.getId());
        msg.setText(String.valueOf(v));
        try {
            absSender.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MonthCommand extends BotCommand {

    public MonthCommand() {
        super("month", "month day");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage msg = new SendMessage();
        System.out.println(chat.getUserName());
        JalaliCalendar today = new JalaliCalendar();
        var v = today.getMonthString();
        System.out.println(v);
        msg.setChatId(chat.getId());
        msg.setText(String.valueOf(v));
        try {
            absSender.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DayOfWeekCommand extends BotCommand {

    public DayOfWeekCommand() {
        super("weak", "weak day");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage msg = new SendMessage();
        System.out.println(chat.getUserName());
        JalaliCalendar today = new JalaliCalendar();
        var v = today.getDayOfWeekString();
        System.out.println(v);
        msg.setChatId(chat.getId());
        msg.setText(String.valueOf(v));
        try {
            absSender.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class YesterdayCommand extends BotCommand {

    public YesterdayCommand() {
        super("yesterday", "Yesterday persian date");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage msg = new SendMessage();
        System.out.println(chat.getUserName());
        JalaliCalendar today = new JalaliCalendar();
        var v = today.getYesterday();
        System.out.println(v.toString());
        msg.setChatId(chat.getId());
        msg.setText(v.toString());
        try {
            absSender.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TomorrowCommand extends BotCommand {

    public TomorrowCommand() {
        super("tomorrow", "tomorrow date");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage msg = new SendMessage();
        System.out.println(chat.getUserName());
        JalaliCalendar today = new JalaliCalendar();
        var v = today.getTomorrow();
        System.out.println(v.toString());
        msg.setChatId(chat.getId());
        msg.setText(v.toString());
        try {
            absSender.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class HolidayCommand extends BotCommand {

    public HolidayCommand() {
        super("holiday", "is holiday");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage msg = new SendMessage();
        System.out.println(chat.getUserName());

        try {
            Date date = Date.getDate("today");
            String is = null;
            if (date.getIsHoliday()) {
                is = "تعطیل است ";
            } else {
                is = "تعطیل نیست ";
            }
            msg.setChatId(chat.getId());
            msg.setText(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            absSender.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class EventsCommand extends BotCommand {

    public EventsCommand() {
        super("events", "events day");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        SendMessage msg = new SendMessage();
        System.out.println(chat.getUserName());

        try {
            JalaliCalendar today = new JalaliCalendar();
            var date = today.getYear() + "/" + today.getMonth() + "/" + today.getDay();
            var url = "https://www.time.ir/fa/event/list/0/" + date;
            Document doc = Jsoup.connect(url).get();
            Elements uls = doc.select("ul");
            Elements lists = uls.get(0).select("li");
            StringBuilder sb = new StringBuilder();
            for (Element list : lists) {
                sb.append(list.text());
                sb.append("\n");
            }
            msg.setChatId(chat.getId());
            msg.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            absSender.execute(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class HelpCommand extends BotCommand {

    private final ICommandRegistry commandRegistry;

    public HelpCommand(ICommandRegistry commandRegistry) {
        super("help", "Get all the commands this bot provides");
        this.commandRegistry = commandRegistry;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {

        StringBuilder helpMessageBuilder = new StringBuilder("Help");
        helpMessageBuilder.append("These are the registered commands for this Bot \n");

        for (IBotCommand botCommand : commandRegistry.getRegisteredCommands()) {
            helpMessageBuilder.append(botCommand.toString()).append("\n");
        }

        SendMessage helpMessage = new SendMessage();
        helpMessage.setChatId(chat.getId().toString());
        helpMessage.enableHtml(true);
        helpMessage.setText(helpMessageBuilder.toString());
        try {
            absSender.execute(helpMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
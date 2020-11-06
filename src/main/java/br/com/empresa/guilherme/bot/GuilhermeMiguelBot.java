package br.com.empresa.guilherme.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class GuilhermeMiguelBot extends TelegramLongPollingBot{


	@Override
	public void onUpdateReceived(Update update) {
		System.out.println(update.getMessage().getText());
		SendMessage message = new SendMessage();
		
		message.setText("Olá");
//		message.setChatId(update.getMessage().getChatId());
		message.setChatId("abcdefghijk");
		
		try {
			execute(message);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBotUsername() {
		return "abllkkkk";
	}

	@Override
	public String getBotToken() {
		return "aaaa";
	}

	public void enviaMensagem(String mensagem) {
		SendMessage message = new SendMessage();
		message.setText(mensagem);
		message.setParseMode("Markdown");
//		message.setChatId(update.getMessage().getChatId());
		message.setChatId("aaaaaa");
		
		
		try {
			execute(message);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

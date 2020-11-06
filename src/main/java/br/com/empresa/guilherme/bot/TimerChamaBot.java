package br.com.empresa.guilherme.bot;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.vdurmont.emoji.EmojiParser;

public class TimerChamaBot implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
         GuilhermeMiguelBot bot = new GuilhermeMiguelBot();		 
		 
         
         //Lista de emojis
         String smile_emoji = EmojiParser.parseToUnicode(":smiley: some text");
		 bot.enviaMensagem(smile_emoji);
		 
	}

}

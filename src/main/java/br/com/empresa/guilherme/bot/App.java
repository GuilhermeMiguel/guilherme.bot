package br.com.empresa.guilherme.bot;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		registraBot();
		SchedulerFactory sf = new StdSchedulerFactory();
		try {
			Scheduler sched = sf.getScheduler();
			sched.start();
			
			JobDetail job = JobBuilder.newJob(TimerChamaBot.class).withIdentity("ChamaBot", "grupo01").build();

			Trigger asOitoDaManha = TriggerBuilder.newTrigger().withIdentity("ChamaBotTRIGGER", "grupo01")
										//hora e minuto
//										.withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(15, 28)).build();
					
										// Parametros Cron(? ? ? ? * *): Segundos, Minutos, Hora, Dia do Mês, Mês, Dia_da_Semana e Ano (opcional)

										.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
					                    .build();

			sched.scheduleJob(job, asOitoDaManha);
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private static void registraBot() {
		ApiContextInitializer.init();
    	TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
    	try {
			telegramBotsApi.registerBot( new GuilhermeMiguelBot());
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}
}

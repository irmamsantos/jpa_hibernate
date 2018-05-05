package com.trainning.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.trainning.modelo.EnergiaDetalhe;

public class DateTimestampTest {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS");

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dateTimestampPU");
		EntityManager em = emf.createEntityManager();

		EnergiaDetalhe ed = new EnergiaDetalhe();
		//Timestamp dataCriacao = new Timestamp(System.currentTimeMillis()); 
		ed.setDataCriacao(new Date());
		
		System.out.println("Data: " + ed.getDataCriacao());
		System.out.println("Data-timestamp: " + ed.getDataCriacao().getTime());
		
		em.getTransaction().begin();
		em.persist(ed);
		em.getTransaction().commit();
		
		System.out.println("Detalhe salvo com sucesso!"+ ed.getCodigo());
		
		EnergiaDetalhe detalhe = em.find(EnergiaDetalhe.class, ed.getCodigo());
		if (detalhe != null) {
			System.out.println(detalhe.toString());
			//System.out.println("São iguais :" + (dataCriacao.equals(ed.getDataCriacao())));
		}
		

		for (Long detalheCodigo = 1L ; detalheCodigo<= ed.getCodigo(); detalheCodigo ++) {
			EnergiaDetalhe detalheFor = em.find(EnergiaDetalhe.class, detalheCodigo);
			if (detalheFor != null) {
				System.out.println(detalheFor.toString());
				System.out.println(sdf.format(detalheFor.getDataCriacao()));
			}
		}
	}
	
	//3.RESULTADOS
/*
Data: Sat May 05 21:58:51 BST 2018
Data-timestamp: 1525553931657
Detalhe salvo com sucesso!4
EnergiaDetalhe [codigo=4, dataCriacao=Sat May 05 21:58:51 BST 2018, dataCriacao-timestamp=1525553931657]
EnergiaDetalhe [codigo=1, dataCriacao=2018-05-05 21:55:55.35, dataCriacao-timestamp=1525553755350]
2018.05.05.21.55.55.350
EnergiaDetalhe [codigo=2, dataCriacao=2018-05-05 21:57:30.387, dataCriacao-timestamp=1525553850387]
2018.05.05.21.57.30.387
EnergiaDetalhe [codigo=3, dataCriacao=2018-05-05 21:58:27.551, dataCriacao-timestamp=1525553907551]
2018.05.05.21.58.27.551
EnergiaDetalhe [codigo=4, dataCriacao=Sat May 05 21:58:51 BST 2018, dataCriacao-timestamp=1525553931657]
2018.05.05.21.58.51.657	
 */
	
	
	//2. RESULTADOS
	//Data: 2018-05-05 19:58:30.822
	//Data-timestamp: 1525546710822
/*	
	Data: 2018-05-05 20:21:37.245
	Data-timestamp: 1525548097245
	Detalhe salvo com sucesso!7
	EnergiaDetalhe [codigo=7, dataCriacao=Sat May 05 20:21:37 BST 2018, dataCriacao-timestamp=2018-05-05 20:21:37.245]
	São iguais :true
	EnergiaDetalhe [codigo=1, dataCriacao=Sat May 05 19:58:15 BST 2018, dataCriacao-timestamp=2018-05-05 19:58:15.0]
	EnergiaDetalhe [codigo=2, dataCriacao=Sat May 05 19:58:31 BST 2018, dataCriacao-timestamp=2018-05-05 19:58:31.0]
	EnergiaDetalhe [codigo=3, dataCriacao=Sat May 05 19:59:50 BST 2018, dataCriacao-timestamp=2018-05-05 19:59:50.0]
	EnergiaDetalhe [codigo=4, dataCriacao=Sat May 05 20:17:07 BST 2018, dataCriacao-timestamp=2018-05-05 20:17:07.0]
	EnergiaDetalhe [codigo=5, dataCriacao=Sat May 05 20:17:36 BST 2018, dataCriacao-timestamp=2018-05-05 20:17:36.0]
	EnergiaDetalhe [codigo=6, dataCriacao=Sat May 05 20:19:30 BST 2018, dataCriacao-timestamp=2018-05-05 20:19:30.0]
	EnergiaDetalhe [codigo=7, dataCriacao=Sat May 05 20:21:37 BST 2018, dataCriacao-timestamp=2018-05-05 20:21:37.245]	
*/
	//1.RESULTADOS
	//Data: Sat May 05 19:18:17 BST 2018
	//Data-timestamp: 1525544297491
	
	//Data: Sat May 05 19:28:04 BST 2018
	//Data-timestamp: 1525544884876

	//Data: Sat May 05 19:32:35 BST 2018
	//Data-timestamp: 1525545155041
	
	//Data: Sat May 05 19:34:01 BST 2018
	//Data-timestamp: 1525545241509
	
	//Data: Sat May 05 19:35:23 BST 2018
	//Data-timestamp: 1525545323848
	
	//Com DateTimeUserType
	//Data: Sat May 05 19:47:08 BST 2018
	//Data-timestamp: 1525546028338
	
	//Data: Sat May 05 19:48:05 BST 2018
	//Data-timestamp: 1525546085497
	
	//EnergiaDetalhe [codigo=1, dataCriacao=2018-05-05 19:18:17.0, dataCriacao-timestamp=1525544297000]
	//EnergiaDetalhe [codigo=2, dataCriacao=2018-05-05 19:28:05.0, dataCriacao-timestamp=1525544885000]
	//EnergiaDetalhe [codigo=3, dataCriacao=2018-05-05 19:32:35.0, dataCriacao-timestamp=1525545155000]
	//EnergiaDetalhe [codigo=4, dataCriacao=2018-05-05 19:34:02.0, dataCriacao-timestamp=1525545242000]
	//EnergiaDetalhe [codigo=5, dataCriacao=2018-05-05 19:35:24.0, dataCriacao-timestamp=1525545324000]
}

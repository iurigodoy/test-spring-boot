package br.com.igtecnologia.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConvidadoPage {
    public static String URL = "http://localhost:9090/index";
	WebDriver driver;
	
	public ConvidadoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visita() {
		driver.get(URL);
	}
	
	public void geraNovo(String nome, int acompanhantes) {
        WebElement txtNome = driver.findElement(By.name("nome"));
        WebElement txtAcompanhantes = driver.findElement(By.name("quantidadeAcompanhantes"));
        txtNome.sendKeys(nome);
        txtAcompanhantes.sendKeys(""+acompanhantes);
        txtNome.submit();
	}
	
	public boolean validaNovo(String nome, int acompanhantes) {
		return	driver.getPageSource().contains(nome) &&
				driver.getPageSource().contains(""+acompanhantes);
	}

}

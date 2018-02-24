package br.com.igtecnologia.view;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConvidadoControllerTest {
	private WebDriver driver;
	private ConvidadoPage pagina;
	
	@Before
	public void initializer(){
    	System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		this.driver = new ChromeDriver();
    	this.pagina = new ConvidadoPage(driver);
	}
	
    @Test
    public void adicionarNormalmente() {
    	pagina.visita();
    	pagina.geraNovo("Rodolfo", 1);
    	assertTrue(pagina.validaNovo("Rodolfo", 1));
    }
    
    @After
    public void finaliza() {
        driver.close();
    }
}

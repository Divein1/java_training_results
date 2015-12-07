package by.java.training.chp.webapp.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class AbstractPage extends WebPage {

	public AbstractPage() {
		add(new Link<Void>("search-page-link") {

			@Override
			public void onClick() {
				setResponsePage(SearchPage.class);
			}
		});
		
		add(new Link<Void>("register-page-link") {
			@Override
			public void onClick() {
				setResponsePage(RegisterPage.class);
			}
		});
		add(new Link<Void>("home-page-link") {
			@Override
			public void onClick() {
				setResponsePage(HomePage.class);
			}
		});
		
		

	}

}

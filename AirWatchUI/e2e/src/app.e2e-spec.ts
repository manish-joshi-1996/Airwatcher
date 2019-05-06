import { AppPage } from './app.po';
import { browser, logging, by } from 'protractor';
import { protractor } from 'protractor/built/ptor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
    browser.ignoreSynchronization=true;
  });

  it('should be redirected to /login route on opening the application', () => {

    page.navigateTo();
    browser.driver.sleep(4000);
    expect(browser.getCurrentUrl()).toContain('/login');
  });
  it('should be redirected to /register route', () => {
    browser.element(by.css('.register-button')).click();
    expect(browser.getCurrentUrl()).toContain('/register');
  });
  it('should be able to register user', () => {
    browser.element(by.id('firstName')).sendKeys('Super User');
    browser.element(by.id('lastName')).sendKeys('Super lastUser');
    browser.element(by.id('userId')).sendKeys('Super User12');
    browser.element(by.id('password')).sendKeys('Super Userpass');
    browser.element(by.css('.register-user')).click();
    browser.driver.sleep(1000);
    expect(browser.getCurrentUrl()).toContain('/login');
  });
  it('should be able to login user and navigate to Countries', () => {
    browser.element(by.id('userId')).sendKeys('Super User12');
    browser.element(by.id('password')).sendKeys('Super Userpass');
    browser.element(by.css('.login-user')).click();
    expect(browser.getCurrentUrl()).toContain('/airwatch');
  });

  
  
});

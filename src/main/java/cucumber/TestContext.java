package cucumber;

import managers.WebDriverManager;
//import managers.PageObjectManager;


    public class TestContext {
        private WebDriverManager webDriverManager;
        //private PageObjectManager pageObjectManager;

        public TestContext(){
            webDriverManager = new WebDriverManager();
            //pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        }

        public WebDriverManager getWebDriverManager() {
            return webDriverManager;
        }

//        public PageObjectManager getPageObjectManager() {
//            return pageObjectManager;
//        }

    }



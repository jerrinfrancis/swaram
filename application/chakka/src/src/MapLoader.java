package src;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserEvent;
import java.io.File;

public class MapLoader extends JWebBrowser {

    private boolean runscript;
    private String script;
    private String url;
    private File htmlfile;
    
    public MapLoader(File file) {
    	super(destroyOnFinalization());
        runscript = false;
        script = "";
        if(file!=null)
        {
        htmlfile = file;	
        url = htmlfile.getAbsolutePath();
        }
        setBarsVisible(false);
        addWebBrowserListener(new WebBrowserAdapter() {
            @Override
            public void loadingProgressChanged(WebBrowserEvent e) {
                System.out.println(getLoadingProgress());
                if (runscript == true && (getLoadingProgress() == 100)) {
                    executeJavascriptWithResult(script);
                    runscript = false;
                    script = "";
                }
            }
        });
    }

    public String generateKeyword(String place) {
        switch (place) {
            case "ശ്രീകാര്യം":
                return "2";
            case "തമ്പാനൂര്‍":
                return "0";
            case "ആറ്റിങ്ങല്‍":
                return "1";
            case "കിഴക്കേക്കോട്ട":
                return "3";
            case "പേരൂര്‍കട":
                return "4";
            case "പട്ടം":
                return "5";
            case "പാളയം":
                return "6";
            case "കാട്ടാകട":
                return "7";
            case "വെഞ്ഞാറമൂട്":
                return "8";
            case "മെടിക്കല്‍കോളേജ്":
                return "9";
        }
        return null;
    }

    public void setHtml() {
        navigate(url);
    }

    public void setHtml(String keyword) {
        String wikiurl = "http://ml.wikipedia.org/w/index.php?search="+keyword+"&title=പ്രത്യേകം:അന്വേഷണം";
        navigate(wikiurl);
    }
    //http://en.wikipedia.org/w/index.php?search=abagnale&title=Special:Search

    public void changeSelection(String start, String end) {
        start = this.generateKeyword(start);
        end = this.generateKeyword(end);
        script = "return changeSelection(" + start + "," + end + ");";
        System.out.println(script);
        if (executeJavascriptWithResult(script) == null) {
            runscript = true;
        }
    }

    public void calcRoute() {
        script = "return calcRoute();";
        System.out.println(script);
        if (executeJavascriptWithResult(script) == null) {
            runscript = true;
        }
    }

    public void setColor(String element, String color) {
        script = "return setColor(\"" + element + "\",\"" + color + "\");";
        System.out.println(script);
        if (executeJavascriptWithResult(script) == null) {
            runscript = true;
        }
    }

    public void scrollBy(int xnum, int ynum) {
        executeJavascript("window.scrollBy(" + xnum + "," + ynum + ");");
    }
}
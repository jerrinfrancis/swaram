package src;	

import javax.swing.*;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.*;



public class Test extends JFrame{
	int i,j,k;
	static MapLoader map;
	static File file=new File("src/src/setMap.html");

	static JFrame frame = new JFrame();
	static JPanel panel =new JPanel(new BorderLayout());

	static BusTiming bustiming= new BusTiming();
	static HomePage homepage= new HomePage();
	static  MainMenu mainmenu = new MainMenu();
	static WikiPedia wikipedia = new WikiPedia();
	static TravelRoute  travelroute = new TravelRoute();
	static NewsChoice newschoice = new NewsChoice();
	static BusDatabase busdatabase = new BusDatabase();
	static ReadTest rss = new ReadTest();

	String option="home";
	String LastPlace="തമ്പാനൂര്‍";
	String start="തമ്പാനൂര്‍",end="പട്ടം";
	String SearchKey="ഡിങ്കന്‍";
	boolean changeone=false;
	boolean flag=false;

	String[] splaces={"തമ്പാനൂര്‍","ആറ്റിങ്ങല്‍","ശ്രീകാര്യം","കിഴക്കേക്കോട്ട","പേരൂര്‍കട","പട്ടം","പാളയം","കാട്ടാകട","വെഞ്ഞാറമൂട്","മെടിക്കല്‍കോളേജ്"};
	String[] swiki={"ശാസ്ത്രം","സംഗീതം","താജ്മഹല്‍","നെല്ലിക്ക","വേഴാമ്പല്‍","ചക്ക","ഘടികാരം","ചലചിത്രം","അദ്ധ്യാപകന്‍","ജ്യോതിശാസ്ത്രം"};
	String[] snews={"മാത്രുഭൂമി","ഇന്ത്യാവിഷന്‍","ദി ഹിന്ദു"};
	ArrayList places = new ArrayList( Arrays.asList(splaces));
	ArrayList wiki = new ArrayList(Arrays.asList(swiki));
	ArrayList news = new ArrayList(Arrays.asList(snews));
	public Test()
	{

		Gui gui = new Gui();
		gui.execute();      
		System.out.println("Inside test : "+Thread.currentThread().getId());

	}

	static void SetPanel(JPanel tmp){

		panel.removeAll();
		panel.setVisible(false);
		panel.add(tmp,BorderLayout.CENTER);
		panel.setVisible(true);

	}
	void Sleep(long time) 
	{
		try {
			Thread.currentThread().sleep(time*1000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	public static void main(String[] args) {
		UIUtils.setPreferredLookAndFeel();
		NativeInterface.open();

		System.out.println("Inside Main  : "+Thread.currentThread().getId());	

		Test t = new Test();



		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {



				Rectangle w = GraphicsEnvironment.getLocalGraphicsEnvironment()
						.getMaximumWindowBounds();
				System.out.println("Inside Run : "+Thread.currentThread().getId());

				frame.setLayout(new BorderLayout());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				// frame.setSize(1366, 768);

				frame.add(panel);
				frame.setVisible(true);
				SetPanel(homepage);
			}
		});
		NativeInterface.runEventPump();

	}


	private class Gui extends SwingWorker<Void, String> {

		ConfigurationManager cm;
		Recognizer HomeRecognizer;
		Recognizer MainRecognizer;
		Recognizer BusTimingRecognizer;
		Recognizer NewsRecognizer;
		Recognizer MapsRecognizer;
		Recognizer WikipediaRecognizer;

		protected Void doInBackground() {



			try
			{	

				System.out.println("Start !! ");
				cm = new ConfigurationManager(Test.class.getResource("final.config.xml"));
				Recognizer HomeRecognizer = (Recognizer) cm.lookup("HomeRecognizer");
				if(HomeRecognizer==null) System.out.println("ERROR !");
				Recognizer MainRecognizer = (Recognizer) cm.lookup("MainRecognizer");
				if(MainRecognizer==null) System.out.println("ERROR !");
				Recognizer BusTimingRecognizer = (Recognizer) cm.lookup("BusTimingRecognizer");
				Recognizer NewsRecognizer = (Recognizer) cm.lookup("NewsRecognizer");
				Recognizer MapsRecognizer = (Recognizer) cm.lookup("MapsRecognizer");
				Recognizer WikipediaRecognizer = (Recognizer) cm.lookup("WikipediaRecognizer");

				HomeRecognizer.allocate();
				MainRecognizer.allocate();
				BusTimingRecognizer.allocate();
				NewsRecognizer.allocate();
				MapsRecognizer.allocate();
				WikipediaRecognizer.allocate();


				// start the microphone or exit if the program  if this is not possible

				Microphone microphone = (Microphone) cm.lookup("microphone");
				if (!microphone.startRecording()){	
					System.out.println("Cannot start microphone.");
					HomeRecognizer.deallocate();
					MainRecognizer.deallocate(); 
					BusTimingRecognizer.deallocate();
					NewsRecognizer.deallocate();
					MapsRecognizer.deallocate();
					WikipediaRecognizer.deallocate();
					System.exit(1);
				}

				Sleep(2);
				while(true)
				{
					option="home";
					publish(option);

					System.out.println("സംസാരിച്ച് തുടങ്ങു . സോഫ്റ്റ്വെയര്‍ അവസാനിപ്പിക്കാന്‍ 'അടയ്ക്കുക' എന്ന് പറയുക \n");
					Result HomeResult = HomeRecognizer.recognize();
					if(HomeResult != null)
					{

						String HomeResultText = HomeResult.getBestFinalResultNoFiller();
						System.out.println("You Said : "+HomeResultText);
						if(HomeResultText.equals(""))
						{
							option="silence";
							publish(option);

							Sleep(1);
							continue;
						}

						if(HomeResultText.equals("അടയ്ക്കുക"))
						{
							option="kill";
							publish("color");
							Sleep(1);
							System.out.println("സോഫ്റ്റ്വെയര്‍ അവസാനിപ്പിക്കുന്നു");
							HomeRecognizer.deallocate();
							MainRecognizer.deallocate(); 
							BusTimingRecognizer.deallocate();
							NewsRecognizer.deallocate();
							MapsRecognizer.deallocate();
							WikipediaRecognizer.deallocate();
							System.exit(1);

						}
						else
						{
							option="thudanguka";
							publish("color");

							Sleep(1);

							while (true) {

								option="mainmenu";
								publish(option);
								System.out.println("Inside doInBackground  : "+Thread.currentThread().getId());
								System.out.println("1.ബസ്സ്സമയം  2.സഞ്ജാരമാര്‍ഗ്ഗം 3.വിക്കിപീഡിയ 4.പ്രധാനവാര്‍ത്തകള്‍ 5.അടയ്ക്കുക");
								System.out.println("സംസാരിച്ച് തുടങ്ങു . സോഫ്റ്റ്വെയര്‍ അവസാനിപ്പിക്കാന്‍ 'അടയ്ക്കുക' എന്ന് പറയുക \n");
								Result MainResult = MainRecognizer.recognize();

								if (MainResult != null) {


									String MainResultText = MainResult.getBestFinalResultNoFiller();
									if(MainResultText.equals(""))
									{
										option="silence";
										publish(option);
									}
									else
									{
										System.out.println("You said:" + MainResultText + "!!\n");
										if(MainResultText.equals("അടയ്ക്കുക"))
										{
											publish("color");

											Sleep(1);
											option="home";
											publish(option);
											break;

										}
										else if(MainResultText.equals("ബസ്സ്സമയം"))
										{


											option="bustiming";
											publish("color");

											Sleep(1);

											publish(option);

											System.out.println(Thread.currentThread().getId());
											while(true){
												System.out.println("1.തമ്പാനൂര്‍  2.ആറ്റിങ്ങല്‍ 3.സ്രീകാര്യം  4.കിഴക്കേകോട്ട  5.പേരൂര്‍കട  6.പട്ടം  7.പാളയം  8.കാട്ടാകട  9.വെഞ്ഞാറമൂട്  10.മെടിക്കല്‍കോളേജ് ");	
												Result BusTimingResult = BusTimingRecognizer.recognize();
												if (BusTimingResult !=null)
												{
													String BusTimingResultText = BusTimingResult.getBestFinalResultNoFiller();

													System.out.println("You said: " + BusTimingResultText + '\n');
													if(BusTimingResultText.equals("അടയ്ക്കുക"))
													{
														System.out.println("പ്രധാന പേജിലേക്ക് പോകുന്നു . ");
														break;
													}
													else
														publish(BusTimingResultText);

												}
												else {
													System.out.println("I can't hear what you said.\n");
												}
											}
										}
										else if (MainResultText.equals("സഞ്ചാരമാര്‍ഗ്ഗം"))
										{
											option="maps";
											publish("color");

											Sleep(1);

											publish(option);

											while(true){
												System.out.println("1.തമ്പാനൂര്‍  2.ആറ്റിങ്ങല്‍ 3.സ്രീകാര്യം  4.കിഴക്കേകോട്ട  5.പേരൂര്‍കട  6.പട്ടം  7.പാളയം  8.കാട്ടാകട  9.വെഞ്ഞാറമൂട്  10.മെടിക്കല്‍കോളേജ് 11.സ്ഥലം ഒന്ന് മാറ്റണം  12.തിരയുക" );
												Result MapsResult = MapsRecognizer.recognize();
												if (MapsResult !=null)
												{
													String MapsResultText = MapsResult.getBestFinalResultNoFiller();
													System.out.println("You said: " + MapsResultText + '\n');
													if(MapsResultText.equals("അടയ്ക്കുക"))
													{
														System.out.println("പ്രധാന പേജിലേക്ക് പോകുന്നു . maps ");
														break;
													}
													publish(MapsResultText);
												}
												else {
													System.out.println("I can't hear what you said.\n");
												}
											}
										}
										else if (MainResultText.equals("വിക്കിപീഡിയ"))
										{
											option="wikipedia";
											publish("color");

											Sleep(1);

											publish(option);
											while(true){

												wikipedia.setText("തിരയുക  ");
								    			Sleep(2);

												System.out.println("1.ശാസ്ത്രം  2.സംഗീതം  3.താജ്മഹല്‍  4.നെല്ലിക്ക  5.വേഴാമ്പല്‍  6.ചക്ക  7.ഘടികാരം  8.ചലചിത്രം  9.അദ്ധ്യാപകന്‍  10.ജ്യോതിശാസ്ത്രം  11.തിരയുക" );

												Result WikipediaResult = WikipediaRecognizer.recognize();

												if (WikipediaResult !=null)
												{
													String WikipediaResultText = WikipediaResult.getBestFinalResultNoFiller();
													System.out.println("You said: " + WikipediaResultText + '\n');
													publish(WikipediaResultText);
													if(WikipediaResultText.equals("അടയ്ക്കുക"))
													{
														System.out.println("പ്രധാന പേജിലേക്ക് പോകുന്നു . ");
														break;
													}
												}
												else {
													System.out.println("I can't hear what you said.\n");
												}
											}
										}
										else if (MainResultText.equals("പ്രധാനവാര്‍ത്തകള്‍"))
										{
											option="news";
											publish("color");

											Sleep(1);

											publish(option);


											while(true){
												System.out.println("1.മാത്രുഭൂമി  2.ഇന്ത്യാവിഷന്‍  3.ദി ഹിന്ദു");
												Result NewsResult = NewsRecognizer.recognize();
												if (NewsResult !=null)
												{
													String NewsResultText = NewsResult.getBestFinalResultNoFiller();
													if(NewsResultText.equals("അടയ്ക്കുക"))
													{
														System.out.println("പ്രധാന പേജിലേക്ക് പോകുന്നു . ");
														break;

													}

													option=NewsResultText;
													publish(option);

													System.out.println("You said: " + NewsResultText + '\n');

												}

											}
										}
									}


								} else {
									publish("silence");
									System.out.println("I can't hear what you said.\n");
								}

							}
						}
					}
					else
					{
						publish("silence");
						System.out.println("I can't hear what you said.\n");

					} 
				}
			} catch (PropertyException e) {
				System.err.println("Problem configuring SwapTest: " + e);
				e.printStackTrace();
			}

			return null;

		}

		protected void done() {

		}
		@Override
		protected void process(List<String> chunks) {		

			String mostRecentValue = chunks.get(chunks.size()-1);
			System.out.println("recent value : "+mostRecentValue);
			if((places.contains(mostRecentValue)) && (option.equals("bustiming")))
			{
				bustiming.settext(mostRecentValue);
				LastPlace=mostRecentValue;
				System.out.println("SET TEXT !! ");
				SetPanel(bustiming);
			}
			else if(mostRecentValue.equals("color"))
			{
				if(option.equals("bustiming"))
				{
					mainmenu.changecolor(mainmenu.BusTiming);
					SetPanel(mainmenu);

				}
				else if(option.equals("news"))
				{
					mainmenu.changecolor(mainmenu.News);
					SetPanel(mainmenu);
				}
				else if(option.equals("maps"))
				{
					mainmenu.changecolor(mainmenu.Sancharamargam);
					SetPanel(mainmenu);
				}
				else if(option.equals("wikipedia"))
				{
					mainmenu.changecolor(mainmenu.Wikipedia);
					SetPanel(mainmenu);
				}
				else if(option.equals("thudanguka") )
				{
					homepage.changecolor(homepage.Thudanguka);
					SetPanel(homepage);
				}
				else if(option.equals("kill"))
				{
					homepage.changecolor(homepage.AdakkukaStart);
					SetPanel(homepage);
				}
				else if(option.equals("mainmenu"))
				{
					mainmenu.changecolor(mainmenu.Adakkuka);
					SetPanel(mainmenu);
				}

			}
			else if(mostRecentValue.equals("bustiming"))
			{


				SetPanel(bustiming);
				System.out.println("Inside process :  "+Thread.currentThread().getId());


			}
			else if(mostRecentValue.equals("തിരയുക") && option.equals("bustiming"))
			{
				busdatabase.BusTiming(LastPlace);
				BusList test = new BusList(busdatabase.row);
				SetPanel(test);
			}
			else if(mostRecentValue.equals("mainmenu"))
			{
				mainmenu=new MainMenu();
				SetPanel(mainmenu);	 
			}
			else if(mostRecentValue.equals("silence") && option.equals("mainmenu"))
			{
				mainmenu.visible(mainmenu.Vyakthamalla,true);

			}
			else if(mostRecentValue.equals("silence") && option.equals("home"))
			{
				mainmenu.visible(mainmenu.Vyakthamalla,true);

			}
			else if(mostRecentValue.equals("news"))
			{

				SetPanel(newschoice);
			}

			else if(news.contains(mostRecentValue))
			{
				try {
					rss.NewsFeed(mostRecentValue);
					ImportantNews impnews = new ImportantNews(mostRecentValue);
					SetPanel(impnews);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(mostRecentValue.equals("maps"))
			{

				String s,e;
				map = new MapLoader(file);
				SetPanel(map);
				map.setHtml();
				s = map.generateKeyword(start);
				e = map.generateKeyword(end);
				map.changeSelection(s, e);

			}
			else  if(places.contains(mostRecentValue) && option.equals("maps") && changeone==false )
			{
				end=mostRecentValue;
				map.changeSelection(start,end);
				System.out.println("changing place 2 ! ");


			}
			else  if(places.contains(mostRecentValue) && option.equals("maps") && changeone==true )
			{
				map.setColor("startplace", "black");
				changeone=false;
				start=mostRecentValue;
				map.changeSelection(start,end);


			}
			else if(mostRecentValue.equals("സ്ഥലം ഒന്ന് മാറ്റണം"))
			{
				map.setColor("startplace", "red");
				changeone=true;
			}
			else if(mostRecentValue.equals("തിരയുക") && option.equals("maps"))
			{
				map.calcRoute();
			}
			else if(mostRecentValue.equals("wikipedia"))
			{
				SetPanel(wikipedia);

			}
			else if(wiki.contains(mostRecentValue))
			{
				SearchKey=mostRecentValue;
				wikipedia.setText(SearchKey);

			}
			else if(mostRecentValue.equals("തിരയുക") && option.equals("wikipedia"))
			{
				map=new MapLoader(null);
				SetPanel(map);
				map.setHtml(SearchKey);


			}
			else if (mostRecentValue.equals("ദി"))
			{
				map.scrollBy(0,-500);
				
			}
			else if(mostRecentValue.equals("ഒന്ന്"))
			{
				map.scrollBy(0,+500);
			}
			else if(mostRecentValue.equals("home"))
			{
				System.out.println("Inside Home !");
				homepage= new HomePage();
				SetPanel(homepage);
			}


		}
	}
}	
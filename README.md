Swaram is a free software initiative aimed towards recognising malayalam speech. The initial goal of the project was to extend the language support of CMU Sphinx engine and use it to recognise malayalam. As an extension to the current work we would like to explore the integration of Artificial Neural Networks in the HMM framework.


Knowledge Base preparation for Malayalam Language.

Limited Vocabulary 
...................

For any application that use sphinx4 to recognise malayalam , we need to create an application specific Acoustic Model and Language Model.


Training Acoustic Model for CMUSphinx : 
http://cmusphinx.sourceforge.net/wiki/tutorialam


The python scripts that generate dictionary file,phone file and transcription files  specific to the application can be found in the application database (Eg: swaram/database/chakka_db/scripts ).

Building Language Model :
http://cmusphinx.sourceforge.net/wiki/tutoriallm


Developing an Application using Sphinx-4  : 
http://cmusphinx.sourceforge.net/sphinx4/doc/ProgrammersGuide.html

Directory Structure of Swaram

				 Swaram
			__________| |_________________	
		       |                              | 	
             	       |	     		      |	
		  Application            	  Database	
    _________________||________	  	_____________||_________
   |      |                    |       |  	 | 	        |
 App1   App2    .......	     AppN      |         |              |
                                       |         |  	        |
                                     App1_db   App2_db  ...... AppN_db
                          ____________||____________________________
		         |       |  	      |	                   |
		         |       |  	      |		           |
                       etc      wav	    Scripts  ....  Model_Parameters



Swaram contains an Application folder and a Database folder . Every application will have a sub-folder under Swaram/Application which contains the source code and resources of the application.Voice data along with dictionary and transcription files are organised under Swaram/Database.

Software Required
------------------
1.Sphinx4 (CMU's Speech Engine in Java)
2.SphinxTrain (For Training acoustic model)
3.CMUCLMTK (For building language model)





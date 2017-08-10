import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends JFrame 
{
	JMenuBar mb;
	JMenu jm1,jm2,jm3,jm4,jm5;
	JMenuItem jmi11,jmi12,jmi13,jmi14;
	JMenuItem jmi21,jmi22,jmi23,jmi24,jmi25;
	JMenuItem jmi31,jmi32;
	JMenuItem jmi41,jmi42;
	JMenuItem jmi51,jmi52;
	 JEditorPane jep;
	 String abc;
	Container con;
	
		public TextEditor()
		{
			setTitle("Text-Editor");
			setSize(1372,732);
			setBackground(Color.white);
			mb=new JMenuBar();
			jm1=new JMenu("File");
			jm2=new JMenu("Edit");
			jm3=new JMenu("Format");
			jm4=new JMenu("View");
			jm5=new JMenu("Help");
			jmi11=new JMenuItem("New");
			
			jmi12=new JMenuItem("Open");
			jmi13=new JMenuItem("Save as");
			jmi14=new JMenuItem("Exit");
    	    
			jm1.add(jmi11);
			jm1.addSeparator();
			jm1.add(jmi12);
			jm1.addSeparator();
			jm1.add(jmi13);
			jm1.addSeparator();
			jm1.add(jmi14);
			jmi21=new JMenuItem("Undo");
			jmi22=new JMenuItem("Cut");
			jmi23=new JMenuItem("Copy");
			jmi24=new JMenuItem("Paste");
			jmi25=new JMenuItem("Delete");
			jm2.add(jmi21);
			jm2.addSeparator();
			jm2.add(jmi22);
			jm2.addSeparator();
			jm2.add(jmi23);
			jm2.addSeparator();
			jm2.add(jmi24);
			jm2.addSeparator();
			jm2.add(jmi25);
			jmi31=new JMenuItem("Word Wrap");
			jmi32=new JMenuItem("Font");
			jm3.add(jmi31);
			jm3.addSeparator();
			jm3.add(jmi32);
			jmi41=new JMenuItem("Calculator");
			
			jmi42=new JMenuItem("Status Bar");
			jmi42.setEnabled(false);
			jm4.add(jmi41);
			jm4.addSeparator();
			jm4.add(jmi42);
			jmi52=new JMenuItem("About Notepad");
			jmi51=new JMenuItem("View Help");
			
			jm5.add(jmi51);
			jm5.addSeparator();
			jm5.add(jmi52);
			setJMenuBar(mb);
			mb.add(jm1);
			mb.add(jm2);
			mb.add(jm3);
			mb.add(jm4);
			mb.add(jm5);
			
			jep = new JEditorPane();
			jep.setEditable(true);
			
			con=getContentPane();
			con.add(new JScrollPane(jep),BorderLayout.CENTER);
			show();
			
			jmi51.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					Runtime r1 = Runtime.getRuntime();
					 try { 
							r1.exec("C:/Users/Nakul/AppData/Local/Google/Chrome/Application/chrome.exe");
						}

						 catch(Exception ear)
					 {
						System.out.println("Exception generated....");
					 }
				}
				});
			jmi41.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					Runtime r = Runtime.getRuntime();
					 try { 
							r.exec("calc");
						}

						 catch(Exception ea)
					 {
						System.out.println("Exception generated....");
					 }
				}
				});
			
			jmi11.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
					{
							 jep.setText("");
					}
					});
		
			jmi12.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
				analyzePath();
				}
				});
				
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				
			jmi14.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);               //For normal exit.
				}
				});
	  }
		  
		  
		  
		  
		   public File getFile()
          {
              JFileChooser fileChooser = new JFileChooser();
              fileChooser.setFileSelectionMode(
             JFileChooser.FILES_AND_DIRECTORIES );
             int result = fileChooser.showOpenDialog( this );
             if ( result == JFileChooser.CANCEL_OPTION ) 
			 System.exit( 1 );                  //For abnormal exit.
            File fileName=null;
            fileName = fileChooser.getSelectedFile();
            if ( ( fileName == null ) || ( fileName.getName().equals( "" ) ) )
                {
                    JOptionPane.showMessageDialog( this, "Invalid File Name", "Invalid File Name", JOptionPane.ERROR_MESSAGE );
                   System.exit( 1 );
               }
                    return fileName;
         }
      
	  public void analyzePath()
          {
               File name = getFile();
			   System.out.println(name.getPath());
               if ( name.exists() )
                    {
						try{
						abc=(name.getPath()).toString();
					    jep.setText(readFile(abc));
					 }
					 catch(Exception eeee){
						 JOptionPane.showMessageDialog( this,eeee.getMessage());
					 }
				    }
             else
                  {
         	       JOptionPane.showMessageDialog( this, name + " does not exist.","ERROR",JOptionPane.ERROR_MESSAGE );
                 }
         }
			
		public String readFile(String fileName)throws IOException
		{
			BufferedReader br=new BufferedReader(new FileReader(fileName));
			try{
			StringBuilder sb=new StringBuilder();
			String line=br.readLine();
			
			while(line !=null)
			{
				sb.append(line);
				sb.append("\n");
				line=br.readLine();
				}
				return sb.toString();
			}finally{
						br.close();
						}
		}
		
		
					
	  public static void main(String args[])
	  {
		TextEditor obj=new TextEditor();
	  }

	  
}
		
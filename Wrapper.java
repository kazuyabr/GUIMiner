import java.awt.Desktop;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
*
* @author yesiam77
*/

public class Wrapper {
	
	private static double version = 1.3;
	private static boolean compileWithMiners = true;
	private static String OS = "";
	private static String homeDir = "";
	private static String selectedMiner = "";
	private static ArrayList<Miner> knownMiners = new ArrayList<Miner>();
	private static DefaultListModel<String> availableMiners = new DefaultListModel<String>();

	private static DefaultListModel<String> availableGPUs = new DefaultListModel<String>();
	private static BufferedReader minerOutput = null;
	private static Runtime rt = Runtime.getRuntime();
	private static Process minerProcess = null;
	private static File jarFile = null;
	private static GUI gui = null;

	private static String advCMDText = "";
	private static String username = "";
	private static String password = "";
	private static String devices = "";
	private static String poolURL = "";
	private static String algo = "";
		
	private static boolean isMinerRunning = false;
	private static int consoleMaxLength = 20000;
	private static int monitorMaxLength = 10000;
	private static String console = "";
	private static String monitor = "";
	
	private static String[] ccMinerAlgos = new String[] { "allium", "bastion", "bitcore", "blake", "blakecoin", "blake2s", "bmw",
			"cryptolight", "cryptonight", "c11/flax", "decred", "deep", "dmd-gr", "equihash", "fresh", "fugue256", "groestl", "hsr",
			"jackpot", "keccak", "keccakc", "lbry", "luffa", "lyra2", "lyra2v2", "lyra2z", "monero", "myr-gr", "neoscrypt", "nist5",
			"penta", "phi1612", "phi2", "polytimos", "quark", "qubit", "scrypt", "scrypt:10", "scrypt:11", "scrypt:12", "scrypt:13",
			"scrypt:14", "scrypt:15", "scrypt:16", "scrypt:17", "scrypt:18", "scrypt:19", "scrypt:20", "scrypt:21", "scrypt-jane",
			"s3", "sha256t", "sia", "sib", "skein", "skein2", "skunk", "sonoa", "stellite", "timetravel", "tribus", "x11evo", "x11",
			"x12", "x13", "x14", "x15", "x16r", "x16s", "x17", "vanilla", "veltor", "whirlpool", "wildkeccak", "zr5" };
	//private static String[] claymoreAlgos = new String[] { "ethash" };
	private static String[] cryptodredgeAlgos = new String[] { "allium", "lyra2rev2", "lyra2z", "neoscrypt", "phi1612", "tribus" };
	//private static String[] sgminerAlgos = new String[] { "" };
	private static String[] zenemyAlgos = new String[] { "aeriumx", "bitcore", "x16r", "x16s", "x17", "c11", "phi", "phi2",
			"tribus", "poly", "skunk", "sonoax", "timetravel", "xevan" };
    
	
	public static void prepare(GUI newGUI, File jarFileLoc)
	{
		gui = newGUI;
		jarFile = jarFileLoc;
		
		String temp = System.getProperty("os.name");
		if(temp.toLowerCase().contains("win"))
		{
			OS = "Windows";
			homeDir = System.getenv("APPDATA");
		}
		else if(temp.toLowerCase().contains("nux"))
		{
			OS = "Linux";
			homeDir = System.getenv("user.home");
		}
		else if(temp.toLowerCase().contains("mac") || temp.toLowerCase().contains("darwin"))
		{
			OS = "Mac";
			homeDir = System.getenv("user.home");
			System.setProperty("apple.eawt.quitStrategy","CLOSE_ALL_WINDOWS");
			JOptionPane.showMessageDialog(getGUI(),"This program does not work on Mac, Sorry!");
			System.out.println("Goodbye");
			System.exit(0);
		}
		
		knownMiners.add(new Miner("ccminer",ccMinerAlgos));
		knownMiners.add(new Miner("cryptodredge",cryptodredgeAlgos));
		knownMiners.add(new Miner("z-enemy",zenemyAlgos));
			
		if(compileWithMiners)
			System.out.println("This version of GUIMiner was compiled with miners");
		else
			System.out.println("This version of GUIMiner was compiled without miners");
				
		try
		{	
			if(OS.equals("Windows"))
			{
				Process pr = rt.exec("wmic path win32_VideoController get name");
				BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
				
				String input = "";
				while((input = br.readLine()) != null)
					if(!input.contains("Name") && !input.isEmpty())
						availableGPUs.addElement(input);
				
				getGUI().getGPUsAvailableList().setModel(availableGPUs);
			}
			else
			{
				//TODO find linux and mac equivalents of the window cmd for finding system GPUs
				getGUI().getGPUsAvailableList().setModel(availableGPUs);
				JOptionPane.showMessageDialog(getGUI(),"The auto-populate feature for the GPU list does not work on Linux.\n"
						+ " Try using the Advanced Commandline Options box to specify the devices to use via the -d argument.\n"
						+ " More information about this argument can be found in the help tab.");
			}
			
			checkAvailableMiners();
				
			ArrayList<String> save = Wrapper.readFile("save.dat");
			if(save.size() >= 5)
			{
				getGUI().getAlgoCombobox().setSelectedItem(save.get(0).replaceAll("#",""));
				getGUI().getPoolURLField().setText(save.get(1).replaceAll("#",""));
				getGUI().getUsernameField().setText(save.get(2).replaceAll("#",""));
				getGUI().getPasswordField().setText(save.get(3).replaceAll("#",""));
				getGUI().getAdvCMDField().setText(save.get(4).replaceAll("#",""));
					
				algo = save.get(0).replaceAll("#","");
				poolURL = save.get(1).replaceAll("#","");
				username = save.get(2).replaceAll("#","");
				password = save.get(3).replaceAll("#","");
				advCMDText = save.get(4).replaceAll("#","");
				System.out.println("Loaded saved data");
			}
			
			ArrayList<String> settings = Wrapper.readFile("settings.dat");
			if(settings.size() >= 5)
			{
				//TODO
				//algo = save.get(0).replaceAll("#","");
			}
			
			checkForUpdate();
			System.out.println("Waiting for user input");
			
		} catch (IOException e) {}
	}
	
	public static void startMiner()
	{
		try
		{
			checkAvailableMiners();
			boolean alreadyExtracted = false;
			System.out.println("Waiting for miner selection");
			
			if(availableMiners.size() > 1)
			{
				for(int j = 0; j < knownMiners.size(); j++)
					if(!checkIfContains(knownMiners.get(j).getAlgos(),algo))
						for(int k = 0; k < availableMiners.size(); k++)
							if(availableMiners.getElementAt(k).toLowerCase().contains(knownMiners.get(j).getShortName()))
								availableMiners.removeElementAt(k);
				
				if(!compileWithMiners)
					for(int j = 0; j < availableMiners.size(); j++)
						for(int k = 0; k < availableMiners.size(); k++)
							if(availableMiners.get(j).equals(availableMiners.get(k)) && !alreadyExtracted)
							{
								availableMiners.removeElementAt(j);
								alreadyExtracted = true;
							}
				
				JList<String> list = new JList<String>();
				list.setModel(availableMiners);
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				JOptionPane.showMessageDialog(getGUI(),list,"Choose a miner",JOptionPane.DEFAULT_OPTION);
				
				if(list.getSelectedIndex() > -1)
					selectedMiner = list.getSelectedValue();
				else
					return;
			}
			else if(availableMiners.size() == 1)
				selectedMiner = availableMiners.get(0);
			else
				if(compileWithMiners)
					JOptionPane.showMessageDialog(getGUI(),"No compatible miner was found for algo \""+algo+"\"\nThis is a bug, please report this!");
				else
					JOptionPane.showMessageDialog(getGUI(),"No compatible miner was found for algo \""+algo+"\"");
			
			if(compileWithMiners)
				if(selectedMiner.contains("(Prepackaged)") && !alreadyExtracted)
					extractFile(selectedMiner);
			
			//TODO adjust these after adding new miners
			System.out.println("Attempting to start "+selectedMiner);
			if(selectedMiner.toLowerCase().contains("ccminer"))
			{
				String args = "-a "+algo+" -o "+poolURL+" -u "+username;
				
				if(!password.isEmpty())
					args += " -p "+password;
				
				if(OS.equals("Windows"))
					if(!devices.isEmpty())
						args += " -d "+devices;
				
				if(!advCMDText.isEmpty())
					args += " "+advCMDText;
				
				System.out.println("Full CMD Args: "+args);
				
				minerProcess = rt.exec(selectedMiner+" "+args);
				minerOutput = new BufferedReader(new InputStreamReader(minerProcess.getInputStream()));

			}
			else if(selectedMiner.toLowerCase().contains("cryptodredge"))
			{
				String args = "-a "+algo+" -o "+poolURL+" -u "+username;
				
				if(!password.isEmpty())
					args += " -p "+password;
				
				if(OS.equals("Windows"))
					if(!devices.isEmpty())
						args += " -d "+devices;
				
				System.out.println("Full CMD Args: "+args);
				
				minerProcess = rt.exec(selectedMiner+" "+args);
				minerOutput = new BufferedReader(new InputStreamReader(minerProcess.getInputStream()));
			}
			/*else if(selectedMiner.toLowerCase().contains("claymore"))
			{
				String args = " -epool "+poolURL+" -ewal "+username;
				
				if(!password.isEmpty())
					args += " -epsw "+password;
				
				if(OS.equals("Windows"))
					if(!devices.isEmpty())
						args += " -di "+devices.replaceAll(",","");
				
				if(!args.contains("-allpools"))
					args += " -allpools 1";
				
				if(!args.contains("-allcoins"))
					args += " -allcoins 1";
				
				if(!args.contains(" -mode"))
					args += " -mode 1";
				
				if(!args.contains(" -dbg"))
					args += " -dbg -1";
				
				if(!args.contains(" -wd"))
					args += " -wd 0";
				
				if(!args.contains(" -r"))
					args += " -r 1";
				
				System.out.println("Full CMD Args: "+args);
				
				minerProcess = rt.exec(selectedMiner+" "+args);
				minerOutput = new BufferedReader(new InputStreamReader(minerProcess.getInputStream()));
			}*/
			else if(selectedMiner.toLowerCase().contains("z-enemy"))
			{
				String args = "-a "+algo+" -o "+poolURL+" -u "+username;
				
				if(!password.isEmpty())
					args += " -p "+password;
				
				if(OS.equals("Windows"))
					if(!devices.isEmpty())
						args += " -d "+devices;
				
				if(!advCMDText.isEmpty())
					args += " "+advCMDText;
				
				System.out.println("Full CMD Args: "+args);
				
				minerProcess = rt.exec(selectedMiner+" "+args);
				minerOutput = new BufferedReader(new InputStreamReader(minerProcess.getInputStream()));
			}
			else
			{
				JOptionPane.showMessageDialog(getGUI(),"Unrecognized Miner, Try using CCMiner, CryptoDredge or Z-Enemy.");
				return;
			}
						        				
			String temp = minerOutput.readLine();
			if(temp.contains("***") || temp.contains("[INFO   ]"))// || selectedMiner.toLowerCase().contains("claymore"))
			{
	        	Wrapper.writeConsole("Starting "+selectedMiner+"...");
				writeConsole(temp);
				getGUI().getStartMinerButton().setText("Stop Miner");
				isMinerRunning = true;
			}
			else
			{
				writeConsole("Failed to start "+selectedMiner+"...");
				writeConsole(temp);
				
				String input = "";
				while((input = minerOutput.readLine()) != null)
				{
					writeConsole(input);
				}
			}
			
			
			new Thread()
			{
				public void run()
				{
					ArrayList<GPU> gpuMonitor = new ArrayList<GPU>();
					String input = "";
					
					try
					{
						//TODO adjust these after adding new miners
						System.out.println("Starting monitoring thread");
						while((input = minerOutput.readLine()) != null && isMinerRunning)
						{
							if(selectedMiner.toLowerCase().contains("ccminer"))
							{
								if(input.contains("GPU #") && !input.contains("kH/W") && input.contains("/s"))//find card hashrates
								{
									int num = Integer.parseInt(input.substring(input.indexOf("#")+1,input.indexOf("#")+2));
									String hash = input.substring(input.indexOf(",")+2);
									
									boolean found = false;
									for(int k = 0; k < gpuMonitor.size(); k++)
									{
										
										if(gpuMonitor.get(k).gpuNum == num)
										{
											found = true;
											gpuMonitor.get(k).setHash(hash);
										}
									}
									
									if(!found)
									{
										gpuMonitor.add(new GPU(num,0,hash));
									}
									
									writeMonitor(input);
								}
								else if(input.contains("GPU #") && input.contains("kH/W"))//find card temps
								{
									int num = Integer.parseInt(input.substring(input.indexOf("#")+1,input.indexOf("#")+2));
									int temp = 0;
	
									String[] split = input.split(" ");
									
									for(int k = 0; k < split.length; k++)
									{
										if(split[k].contains("C"))
											temp = Integer.parseInt(split[k].replaceAll("[^0-9]+",""));
									}
									
									boolean found = false;
									for(int k = 0; k < gpuMonitor.size(); k++)
									{
										
										if(gpuMonitor.get(k).gpuNum == num)
										{
											found = true;
											gpuMonitor.get(k).gpuTemp = temp;
										}
									}
									
									if(!found)
									{
										gpuMonitor.add(new GPU(num,temp,"0"));
									}
									
									writeMonitor(input);
								}
							}
							
							
							/*else if(selectedMiner.toLowerCase().contains("claymore"))
							{
								if(input.contains("GPU") && input.contains("t="))//find card temps
								{
									if(input.contains(","))
									{
										String[] inputSplit = input.split(",");
										
										for(int j = 0; j < inputSplit.length; j++)
										{
											int temp = 0;
											int num = Integer.parseInt(input.substring(input.indexOf("GPU")+3,input.indexOf("GPU")+4));
											
											String[] split = input.split(" ");
											for(int k = 0; k < split.length; k++)
											{
												if(split[k].contains("C"))
													temp = Integer.parseInt(split[k].replaceAll("[^0-9]+",""));
											}
											
											boolean found = false;
											for(int k = 0; k < gpuMonitor.size(); k++)
											{
												
												if(gpuMonitor.get(k).gpuNum == num)
												{
													found = true;
													gpuMonitor.get(k).gpuTemp = temp;
												}
											}
											
											if(!found)
											{
												gpuMonitor.add(new GPU(num,temp,"0 kH/s"));
											}
										}
									}
									else
									{
										int temp = 0;
										int num = Integer.parseInt(input.substring(input.indexOf("GPU")+3,input.indexOf("GPU")+4));
										
										String[] split = input.split(" ");
										for(int k = 0; k < split.length; k++)
										{
											if(split[k].contains("C"))
												temp = Integer.parseInt(split[k].replaceAll("[^0-9]+",""));
										}
										
										boolean found = false;
										for(int k = 0; k < gpuMonitor.size(); k++)
										{
											
											if(gpuMonitor.get(k).gpuNum == num)
											{
												found = true;
												gpuMonitor.get(k).gpuTemp = temp;
											}
										}
										
										if(!found)
										{
											gpuMonitor.add(new GPU(num,temp,"0 kH/s"));
										}
									}
									
									writeMonitor(input);
								}
								else if(input.contains("GPU") && input.contains("ETH: ") && input.contains("/s"))//find card hashrates
								{
									if(input.contains(","))
									{
										String[] inputSplit = input.split(",");
										
										for(int j = 0; j < inputSplit.length; j++)
										{
											int num = Integer.parseInt(input.substring(input.indexOf("GPU")+3,input.indexOf("GPU")+4));
											String hash = "";
											
											String[] split = input.split(" ");
												hash = split[1]+" "+split[2];
											
											boolean found = false;
											for(int k = 0; k < gpuMonitor.size(); k++)
											{
												
												if(gpuMonitor.get(k).gpuNum == num)
												{
													found = true;
													gpuMonitor.get(k).setHash(hash);
												}
											}
											
											if(!found)
											{
												gpuMonitor.add(new GPU(num,0,hash));
											}
										}										
									}
									else
									{
										int num = Integer.parseInt(input.substring(input.indexOf("GPU")+3,input.indexOf("GPU")+4));
										String hash = "";
										
										String[] split = input.split(" ");
											hash = split[1]+" "+split[2];
										
										boolean found = false;
										for(int k = 0; k < gpuMonitor.size(); k++)
										{
											
											if(gpuMonitor.get(k).gpuNum == num)
											{
												found = true;
												gpuMonitor.get(k).setHash(hash);
											}
										}
										
										if(!found)
										{
											gpuMonitor.add(new GPU(num,0,hash));
										}
									}
									
									writeMonitor(input);
								}
								else if(input.contains("ETH - Total Speed:"))
								{									
									writeMonitor(input);
								}
							}
							*/
							
							
							else if(selectedMiner.toLowerCase().contains("cryptodredge"))
							{
								if(input.contains("- GPU") && input.contains("T="))//find card temps and hashrates
								{
									int temp = 0;
									int num = Integer.parseInt(input.substring(input.indexOf("GPU")+3,input.indexOf("GPU")+4));
									String hash = input.substring(input.indexOf("Avr ")+4,input.indexOf(")"));
									
									String[] split = input.split(" ");
									for(int k = 0; k < split.length; k++)
									{
										if(split[k].contains("C"))
											temp = Integer.parseInt(split[k].replaceAll("[^0-9]+",""));
									}
									
									boolean found = false;
									for(int k = 0; k < gpuMonitor.size(); k++)
									{
										
										if(gpuMonitor.get(k).gpuNum == num)
										{
											found = true;
											gpuMonitor.get(k).setHash(hash);
											gpuMonitor.get(k).gpuTemp = temp;
										}
									}
									
									if(!found)
									{
										gpuMonitor.add(new GPU(num,temp,hash));
									}
									
									writeMonitor(input);
								}
							}
							
							
							else if(selectedMiner.toLowerCase().contains("z-enemy"))
							{
								if(input.contains("GPU#") && input.contains("/s"))//find card hashrates (no temps in z-enemy output)
								{
									int num = Integer.parseInt(input.substring(input.indexOf("#")+1,input.indexOf("#")+2));
									String hash = input.substring(input.indexOf(",")+2);
									
									boolean found = false;
									for(int k = 0; k < gpuMonitor.size(); k++)
									{
										
										if(gpuMonitor.get(k).gpuNum == num)
										{
											found = true;
											gpuMonitor.get(k).setHash(hash);
										}
									}
									
									if(!found)
									{
										gpuMonitor.add(new GPU(num,0,hash));
									}
									
									writeMonitor(input);
								}
							}
							
							
							if(gpuMonitor.size() > 0)
							{
								int avgTemp = 0;
								double totalHashrate = 0;
								
								String suffix = "";
								for(int k = 0; k < gpuMonitor.size(); k++)
								{
									avgTemp += gpuMonitor.get(k).gpuTemp;
									totalHashrate += gpuMonitor.get(k).gpuHash;
								}
								
								if(totalHashrate > 1000)
								{
									totalHashrate /= 1000;
									suffix = " kH/s";
									
									if(totalHashrate > 1000)
									{
										totalHashrate /= 1000;
										suffix = " MH/s";
										
										if(totalHashrate > 1000)
										{
											totalHashrate /= 1000;
											suffix = " GH/s";
											
											if(totalHashrate > 1000)
											{
												totalHashrate /= 1000;
												suffix = " TH/s";
											}
										}
									}
								}
								
								getGUI().getAlgorithmField().setText(algo);
								getGUI().getTotalGPUsHashingField().setText(String.valueOf(gpuMonitor.size()));
								getGUI().getAvgTempField().setText(String.valueOf((double)avgTemp/(double)gpuMonitor.size()));
								getGUI().getTotalHashrateField().setText(round(totalHashrate,2)+suffix);
							}
							
							if(!input.isEmpty())
								writeConsole(input);
						}
						
					} catch (IOException e) {}
					System.out.println("Killed monitoring thread");
				}
				
				class GPU
				{
					int gpuNum = -1;
					int gpuTemp = 0;
					double gpuHash = 0;
					
					GPU(int num, int temp, String hash)
					{
						gpuNum = num;
						gpuTemp = temp;
						setHash(hash);
					}
					
					public void setHash(String hash)
					{
						if(hash.toLowerCase().contains("th/s"))
							gpuHash = Double.parseDouble(hash.replaceAll("\\[0m","").replaceAll("[^0-9\\.]+",""))*1000*1000*1000*1000;
						else if(hash.toLowerCase().contains("gh/s"))
							gpuHash = Double.parseDouble(hash.replaceAll("\\[0m","").replaceAll("[^0-9\\.]+",""))*1000*1000*1000;
						else if(hash.toLowerCase().contains("mh/s"))
							gpuHash = Double.parseDouble(hash.replaceAll("\\[0m","").replaceAll("[^0-9\\.]+",""))*1000*1000;
						else if(hash.toLowerCase().contains("kh/s"))
							gpuHash = Double.parseDouble(hash.replaceAll("\\[0m","").replaceAll("[^0-9\\.]+",""))*1000;
						else
							gpuHash = Double.parseDouble(hash.replaceAll("\\[0m","").replaceAll("[^0-9\\.]+",""));
					}
				}
				
			}.start();
			
		} catch (IOException e) {}		
	}
		
	public static boolean checkReady()
	{
		if(!poolURL.isEmpty() && !username.isEmpty() && !isMinerRunning)
			return true;
		else
			return false;
	}
	
	public static void stopMiner()
	{
		if(isMinerRunning)
		{
			System.out.println("Stopping "+selectedMiner);
			Wrapper.writeConsole("Stopping "+selectedMiner+"...");
			getGUI().getStartMinerButton().setText("Start Miner");
			selectedMiner = "";
			
			minerProcess.destroy();
			minerProcess.destroy();
			isMinerRunning = false;
		}
	}
	
	//TODO adjust after adding new miners
	public static void checkAvailableMiners() throws IOException
	{
		System.out.println("Refreshing list of available miners");
		
		selectedMiner = "";
		availableMiners.clear();
		
		if(!compileWithMiners)
		{
			List<String> results = new ArrayList<String>();
			File[] files = new File(jarFile.getParentFile().getCanonicalPath()).listFiles();
	
			for (File file : files) {
			    if (file.isFile()) {
			        results.add(file.getName());
			    }
			}
			
			for(int k = 0; k < results.size(); k++)
			{
				for(int j = 0; j < knownMiners.size(); j++)
				if(results.get(k).toLowerCase().replaceAll("-","").contains(knownMiners.get(j).getShortName().replaceAll("-","")))
				{
					availableMiners.addElement(results.get(k));
				}
			}
		}
				
		if(OS.equals("Windows"))
		{
			boolean nVidia = false;
			boolean AMD = false;
			for(int k = 0; k < availableGPUs.size(); k++)
			{
				if(availableGPUs.getElementAt(k).toLowerCase().contains("nvidia") || availableGPUs.getElementAt(k).toLowerCase().contains("geforce"))
					nVidia = true;
				else if(availableGPUs.getElementAt(k).toLowerCase().contains("amd") || availableGPUs.getElementAt(k).toLowerCase().contains("radeon"))
					AMD = true;
			}
			
			//These come prepackaged in .jar
			if(compileWithMiners)
			{
				if(nVidia)
				{
					availableMiners.addElement("ccminer-x64(Prepackaged).exe");
					availableMiners.addElement("CryptoDredge(Prepackaged).exe");
					availableMiners.addElement("z-enemy(Prepackaged).exe");
				}
				
				if(AMD)
				{
					
				}
			}
			
			for(int k = 0; k < availableMiners.size(); k++)
				if(!availableMiners.getElementAt(k).contains(".exe"))
				{
					availableMiners.removeElementAt(k);
					k--;
				}
		}
		else if(OS.equals("Linux"))
		{
			boolean nVidia = false;
			boolean AMD = false;
			for(int k = 0; k < availableGPUs.size(); k++)
			{
				if(availableGPUs.getElementAt(k).toLowerCase().contains("nvidia") || availableGPUs.getElementAt(k).toLowerCase().contains("geforce"))
					nVidia = true;
				else if(availableGPUs.getElementAt(k).toLowerCase().contains("amd") || availableGPUs.getElementAt(k).toLowerCase().contains("radeon"))
					AMD = true;
			}

			//These come prepackaged in .jar
			if(compileWithMiners)
			{
				if(nVidia)
				{
					availableMiners.addElement("z-enemy-ubuntu-cuda9_1(Prepackaged)");
				}
				
				if(AMD)
				{
					
				}
			}
		}
		
		if(availableMiners.size() == 0)
		{
			System.out.println(" - No compatible miners found");
			JOptionPane.showMessageDialog(getGUI(),"Unable to find a compatible miner either prepackaged or in the same directory as this GUI.\n"
					+ "Compatible miners include: CCMiner, CryptoDredge and Z-Enemy");
			System.out.println("Goodbye");
			System.exit(0);
		}
		else
		{
			int save = getGUI().getAlgoCombobox().getSelectedIndex();
			getGUI().getAlgoCombobox().setModel(new javax.swing.DefaultComboBoxModel<>(Wrapper.getFullAlgoList()));
			getGUI().getAlgoCombobox().setSelectedIndex(save);
		}
	}
	
	public static void checkForUpdate()
	{
		String response = "";
		
		try
		{
			System.out.println("Looking for new version of GUIMiner");
			URL url = new URL("https://api.github.com/repos/yesiam77/GUIMiner/releases/latest");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String input = "";
			while ((input = br.readLine()) != null) {
				response += input+"\n";
			}
			is.close();
				
		} catch (IOException e) {
			System.out.println(" - Unable to connect to Github API");
		}
		
		if(response.contains("\"tag_name\""))
		{
			String versionStr = response.substring(response.indexOf("\"tag_name\"")+12);
			versionStr = versionStr.substring(0,versionStr.indexOf(","));
			double newVersion = Double.parseDouble(versionStr.replaceAll("[^0-9\\.]+",""));
			
			if(newVersion > version)
			{
				System.out.println(" - Found new version of GUIMiner");
				JLabel label = new JLabel();
			    Font font = label.getFont();

			    StringBuffer style = new StringBuffer("font-family:" + font.getFamily() + ";");
			    style.append("font-weight:" + (font.isBold() ? "bold" : "normal") + ";");
			    style.append("font-size:" + font.getSize() + "pt;");

			    JEditorPane ep = new JEditorPane("text/html","<html><body style=\"" + style + "\">"
			            + "There is a new version of the miner available <a href=\"https://github.com/yesiam77/GUIMiner/releases\">here</a>."
			            + "</body></html>");

			    ep.setEditable(false);
			    ep.setBackground(label.getBackground());
			    ep.addHyperlinkListener(new HyperlinkListener()
			    {
			        @Override
			        public void hyperlinkUpdate(HyperlinkEvent e)
			        {
			        	if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
			            if(Desktop.isDesktopSupported())
			            {
			                Desktop desktop = Desktop.getDesktop();
			                try
			                {
			                    desktop.browse(new URI("https://github.com/yesiam77/GUIMiner/releases"));
			                    
			                } catch (IOException | URISyntaxException e1) {
			                    e1.printStackTrace();
			                }
			            }
			        }
			    });
				
				JOptionPane.showMessageDialog(getGUI(),ep);
			}
			else
				System.out.println(" - This is already the most recent version of GUIMiner");
		}
	}
	
	public static ArrayList<String> deDupe(ArrayList<String> array)
	{
		Set<String> temp = new LinkedHashSet<>();
		
		temp.addAll(array);
		array.clear();
		array.addAll(temp);
		Collections.sort(array);
		return array;
	}
	
	public static String[] getFullAlgoList()
	{
		ArrayList<String> fullAlgoList = new ArrayList<String>();
		
		for(int k = 0; k < availableMiners.size(); k++)
		{
			System.out.println(" - Found: "+availableMiners.getElementAt(k).toLowerCase());
			for(int j = 0; j < knownMiners.size(); j++)
				if(availableMiners.getElementAt(k).toLowerCase().contains(knownMiners.get(j).getShortName()))
					Collections.addAll(fullAlgoList,knownMiners.get(j).getAlgos());
		}
		
		return deDupe(fullAlgoList).toArray(new String[0]);
	}
	
	//TODO add this
	public static void configBoxChanged()
	{
		
	}
	
	//TODO add this
	public static String[] getSavedConfigs()
	{
		ArrayList<String> configs = new ArrayList<String>();
		
		configs.add("testConfig1");
		configs.add("testConfig2");
		configs.add("testConfig3");
		configs.add("testConfig4");
		configs.add("testConfig5");
		
		return configs.toArray(new String[0]);
	}

	public static void writeConsole(String newLine)
	{
		newLine = newLine.replaceAll("\\[01;37m","").replaceAll("\\[32m","").replaceAll("\\[0m","").replaceAll("\\[22;31m","").replaceAll("\\[22;33m","")
				.replaceAll("\\[01;30m","").replaceAll("\\[33m","").replaceAll("\\[31m","").replaceAll("\\[22;37m","").replaceAll("\\[22;32m","").replaceAll("\\[36m","");
		console += newLine+"\n";
		
		if(console.length() > consoleMaxLength)
			console = console.substring(console.indexOf("\n")+1);
		
		getGUI().getConsoleTextArea().setText(console);
		getGUI().getConsoleTextArea().setCaretPosition(getGUI().getConsoleTextArea().getDocument().getLength());
	}
	
	public static void writeMonitor(String newLine)
	{
		newLine = newLine.replaceAll("\\[01;37m","").replaceAll("\\[32m","").replaceAll("\\[0m","").replaceAll("\\[22;31m","").replaceAll("\\[22;33m","")
				.replaceAll("\\[01;30m","").replaceAll("\\[33m","").replaceAll("\\[31m","").replaceAll("\\[22;37m","").replaceAll("\\[22;32m","").replaceAll("\\[36m","");
		monitor += newLine+"\n";
		
		if(monitor.length() > monitorMaxLength)
			monitor = monitor.substring(monitor.indexOf("\n")+1);
		
		getGUI().getMonitorTextArea().setText(monitor);
		getGUI().getMonitorTextArea().setCaretPosition(getGUI().getMonitorTextArea().getDocument().getLength());
	}
	
	public static boolean checkIfContains(String[] myStringArray, String stringToLocate) {
	    for (String element:myStringArray ) {
	        if ( element.equals( stringToLocate)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public static void extractFile(String resourceName)
	{
		try
		{
			File tempFile = new File(jarFile.getParentFile()+"/"+resourceName);
			tempFile.deleteOnExit();
			Files.copy(Wrapper.class.getResourceAsStream(resourceName),Paths.get(tempFile.getCanonicalPath()), StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public static ArrayList<String> readFile(String fileName)
	{
		String tableData = "";
		String line = "";
		ArrayList<String> fileContent = new ArrayList<String>();
		
		try
		{
			File saveFile = new File(homeDir+"/GUIMiner/"+fileName);
		
			if(saveFile.exists())
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(saveFile),"UTF-8"));
			
				while((line = br.readLine()) != null)
				{
					if(!line.contains("%"))
					{
						tableData += line;
					}
				}
				br.close();
								
				for(int k = 0; k < tableData.split(";").length; k++)
				{
					fileContent.add(tableData.split(";")[k]);
				}
			}
					
		} catch (IOException e){}	
		
		return fileContent;
	}
	
	public static void clearFile(String fileName)
	{	
		try
		{
			File saveFile = new File(homeDir+"/GUIMiner/"+fileName);
			
			if(!saveFile.exists())
			{
				new File(homeDir+"/GUIMiner/").mkdirs();
				saveFile.createNewFile();
			}
			else
				new FileOutputStream(saveFile,false).close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addToFile(String fileName, String content)
	{	
		try
		{
			File saveFile = new File(homeDir+"/GUIMiner/"+fileName);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(saveFile,true),"UTF-8"));
					
			bw.write(content);
			bw.newLine();
			bw.close();
			return;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static double round(double value, int places)
	{
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public static void setDevices(int[] newDevices)
	{
		if(newDevices.length == 0)
			return;
		
		String temp = "";
		for(int k = 0; k < newDevices.length; k++)
			temp += newDevices[k]+",";
		
		devices = temp.substring(0,temp.length()-1);
	}
	
	public static GUI getGUI()
	{
		return gui;
	}
	
	public static void setPassword(String newPassword)
	{
		password = newPassword;
	}
	
	public static void setUsername(String newUsername)
	{
		username = newUsername;
	}
	
	public static void setPoolURL(String newPoolURL)
	{
		poolURL = newPoolURL;
	}
	
	public static void setAlgo(String newAlgo)
	{
		algo = newAlgo;
	}
	
	public static void setAdvCMDText(String newAdvCMD)
	{
		advCMDText = newAdvCMD;
	}
	
	public static boolean isMinerRunning()
	{
		return isMinerRunning;
	}
}

class Miner
{
	String shortName = "";
	String[] algos = new String[0];
	
	Miner(String shortName, String[] algos) {
		this.shortName = shortName;
		this.algos = algos;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public String[] getAlgos() {
		return algos;
	}
}

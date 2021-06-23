import java.awt.event.*;
import java.awt.*;
public class SketchPad extends Frame implements ActionListener, WindowListener, MouseListener, MouseMotionListener 
{
	String selectedShape = new String("Square");
        String selectedColor = new String("Blue");
        int upLX, upLY, W, H,X1, Y1, X2,Y2;
    	String[] extrasList = {"Clear", "Exit"};
    	String[] colorList = {"Black", "Cyan", "Green", "Yellow", "Magenta", "Red", "Blue"};
    	String[] shapeList = {"Line", "Rectangle", "Square", "Circle"};
   	public void windowClosing(WindowEvent eve) 
	{
        	System.exit(0);
    	}
	public void windowActivated(WindowEvent we) 
	{}
        public void windowOpened(WindowEvent we) 
	{}
        public void windowIconified(WindowEvent we) 
	{}
        public void windowClosed(WindowEvent we) 
	{}
        public void windowDeactivated(WindowEvent we) 
	{}
        public void windowDeiconified(WindowEvent we) 
	{}
        public void mouseMoved(MouseEvent me) 
	{}
        public void mouseClicked(MouseEvent me) 
	{}
        public void mouseExited(MouseEvent me) 
	{}
        public void mouseEntered(MouseEvent me) 
	{}
        public void itemStateChanged(ItemEvent ie) 
	{}
	public SketchPad() 
	{
        	setTitle("PHEONIX");
        	addMouseMotionListener(this);
        	addWindowListener(this);
        	addMouseListener(this);
        	setLayout(null);
        	setMenuItems();
        	setBackground(Color.white);
		setVisible(true);
		setSize(500,500);
    	}

	public void actionPerformed(ActionEvent ape) 
	{
        	Graphics ga = getGraphics();
        	Object s = ape.getActionCommand();
        	for (int i = 0; i != colorList.length; i++) 
		{
            		if (s.equals(colorList[i])) 
			{
                		selectedColor = colorList[i];
                		return;
            		}
        	}
        	for (int i = 0; i != shapeList.length; i++) 
		{
            		if (s.equals(shapeList[i])) 
			{
               			 selectedShape = shapeList[i];
                		return;
            		}
        	}
        	if (s.equals("Exit")) 
		{
            		dispose();
            		return;
        	} 
		else if (s.equals("Clear")) 
		{
            		ga.clearRect(0, 0, 700, 700);
            		return;
        	}
    	}
	void chooseColor(Graphics ga) 
	{
        	for (int i = 0; i != colorList.length; i++) 
		{
            		if (selectedColor.equals(colorList[i])) 
			{
                		switch (i) 
				{
                    			case 0:
                        			ga.setColor(Color.black);
                   	     			break;
                    			case 1:
                        			ga.setColor(Color.cyan);
                        			break;
                    			case 2:
                        			ga.setColor(Color.green);
                        			break;
                    			case 3:
                        			ga.setColor(Color.yellow);
                        			break;
                    			case 4:
                        			ga.setColor(Color.magenta);
                        			break;
                    			case 5:
                        			ga.setColor(Color.red);
                        			break;
                    			case 6:
                        			ga.setColor(Color.blue);
                		}
            		}
        	}
    	}
	public void mouseReleased(MouseEvent me) 
	{
        	Graphics ga = getGraphics();
        	chooseColor(ga);
        	X2 = me.getX();
        	Y2 = me.getY();
        	if (selectedShape.equals("Line")) 
		{
            		ga.drawLine(X1,Y1,X2,Y2);
        	}
		else if (selectedShape.equals("Circle")) 
		{
            		drawSelectedShape(ga, "Circle");
        	} 
		else if (selectedShape.equals("Square")) 
		{
            		drawSelectedShape(ga, "Square");
        	} 
		else if (selectedShape.equals("Rectangle")) 
		{
            		drawSelectedShape(ga, "Rectangle");
        	}
    	}
	void drawSelectedShape(Graphics ga, String selectedshape) 
	{
        	upLX = Math.min(X1,X2);
        	upLY = Math.min(Y1,Y2);
        	W = Math.abs(X1-X2);
        	H = Math.abs(Y1-Y2);
        	if (selectedshape.equals("Square")) 
		{
            		ga.fillRect(upLX, upLY, W, W);
        	} 
		else if (selectedshape.equals("Rectangle")) 
		{
            		ga.fillRect(upLX, upLY, W, H);
        	} 
		else if (selectedshape.equals("Circle")) 
		{
            		ga.fillOval(upLX, upLY, W, W);
        	}
    	}
	public void mouseDragged(MouseEvent me) 
	{
        	Graphics ga = getGraphics();
        	X2 = me.getX();
        	Y2 = me.getY();
    	}
	public void mousePressed(MouseEvent me) 
	{
        	X1 = me.getX();
        	Y1 = me.getY();
        }
	void setMenuItems() 
	{
        	MenuBar mb = new MenuBar();
        	Menu menuShape = new Menu("Shape");
        	for (int i = 0; i != shapeList.length; i++) 
		{
            		menuShape.add(shapeList[i]);
        	}
        	mb.add(menuShape);
        	menuShape.addActionListener(this);
        	Menu menuColor = new Menu("Colors");
        	for (int i = 0; i != colorList.length; i++) 
		{
        		menuColor.add(colorList[i]);
        	}
        	mb.add(menuColor);
        	menuColor.addActionListener(this);
        	Menu menuExtras = new Menu("Extras");
        	for (int i = 0; i != extrasList.length; i++) 
		{
            		menuExtras.add(extrasList[i]);
        	}
        	mb.add(menuExtras);
        	menuExtras.addActionListener(this);
        	setMenuBar(mb);
    	}
	public static void main(String[] args) 
	{
        	SketchPad sp = new SketchPad();
        }
}

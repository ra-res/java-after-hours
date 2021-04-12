import java.awt.*;
import java.awt.event.*;

public class Painter extends Frame implements ActionListener, MouseListener, MouseMotionListener {
    private static final long serialVersionUID = 1L;
    private MenuBar menubar;
    private Menu menu1, menu2, menu3;
    private MenuItem newMenuItem, openMenuItem, saveMenuItem, colourMenuItem, exitMenuItem;

    private CheckboxMenuItem linesMenuItem;

    public Painter() {
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
        generateMenuBar();
        setMenuBar(menubar);
    }

    private void generateMenuBar() {
        menubar = new MenuBar();
        menu1 = new Menu("File");
        menu2 = new Menu("Draw");
        menu3 = new Menu("Effects");

        // newMenuItem = initMenuItem("New", menu1);
        // openMenuItem = initMenuItem("Open...", menu1);
        // saveMenuItem = initMenuItem("Save As...", menu1);
        // colourMenuItem = initMenuItem("Select Colour", menu3);
        // exitMenuItem = initMenuItem("Exit", menu1);


        newMenuItem = new MenuItem("New");
        menu1.add(newMenuItem);
        newMenuItem.addActionListener(this);

        openMenuItem = new MenuItem("Open...");
        menu1.add(openMenuItem);
        openMenuItem.addActionListener(this);

        saveMenuItem = new MenuItem("Save As...");
        menu1.add(saveMenuItem);
        saveMenuItem.addActionListener(this);

        colourMenuItem = new MenuItem("Select Colour");
        menu3.add(colourMenuItem);
        colourMenuItem.addActionListener(this);

        exitMenuItem = new MenuItem("Exit");
        menu1.add(exitMenuItem);
        exitMenuItem.addActionListener(this);

        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        setMenuBar(menubar);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setSize(200, 200);
        setVisible(true);

    }

    private MenuItem initMenuItem(String name, Menu menu) {
        MenuItem tempMenuItem = new MenuItem(name);
        menu.add(tempMenuItem);
        tempMenuItem.addActionListener(this);
        return tempMenuItem;
    }

    public static void main(String[] args) {
        new Painter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}

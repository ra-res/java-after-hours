import java.awt.*;
import java.awt.event.*;

public class Painter extends Frame implements ActionListener, MouseMotionListener, MouseListener, ItemListener {
  private static final long serialVersionUID = 1L;
  private MenuBar menubar;
  private Menu menu1, menu2, menu3;
  private MenuItem newMenuItem, openMenuItem, saveMenuItem, colourMenuItem, exitMenuItem;
  private CheckboxMenuItem linesMenuItem, ellipsesMenuItem, rectanglesMenuItem, roundMenuItem, freehandMenuItem,
      thickMenuItem, shadowMenuItem, textMenuItem, transparentMenuItem, textureMenuItem, gradientMenuItem,
      solidMenuItem, plainMenuItem;

  public Painter() {
    setLayout(null);
    addMouseListener(this);
    addMouseMotionListener(this);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    menubar = new MenuBar();
    menu1 = new Menu("File");
    menu2 = new Menu("Draw");
    menu3 = new Menu("Effects");

    newMenuItem = initMenuItem("New", menu1);
    openMenuItem = initMenuItem("Open...", menu1);
    saveMenuItem = initMenuItem("Save As...", menu1);
    colourMenuItem = initMenuItem("Select Colour", menu3);
    exitMenuItem = initMenuItem("Exit", menu1);

    linesMenuItem = initCheckBoxMenuItem("Draw lines", menu2);
    ellipsesMenuItem = initCheckBoxMenuItem("Draw ellipses", menu2);
    rectanglesMenuItem = initCheckBoxMenuItem("Draw ellipses", menu2);
    roundMenuItem = initCheckBoxMenuItem("Draw round rectangles", menu2);
    freehandMenuItem = initCheckBoxMenuItem("Draw freehand", menu2);
    plainMenuItem = initCheckBoxMenuItem("Draw freehand", menu3);
    solidMenuItem = initCheckBoxMenuItem("Solid fill", menu3);
    gradientMenuItem = initCheckBoxMenuItem("Gradient fill", menu3);
    textureMenuItem = initCheckBoxMenuItem("Texture fill", menu3);
    transparentMenuItem = initCheckBoxMenuItem("Transparent", menu3);
    textMenuItem = initCheckBoxMenuItem("Draw text", menu2);
    thickMenuItem = initCheckBoxMenuItem("Draw thick lines", menu3);
    shadowMenuItem = initCheckBoxMenuItem("Drop shadow", menu3);

    menubar.add(menu1);
    menubar.add(menu2);
    menubar.add(menu3);
    setMenuBar(menubar);
    setVisible(true);
    setSize(400, 400);
  }

  private CheckboxMenuItem initCheckBoxMenuItem(String name, Menu menu) {
    CheckboxMenuItem tempCheckboxItem = new CheckboxMenuItem(name);
    menu.add(tempCheckboxItem);
    tempCheckboxItem.addItemListener(this);
    return tempCheckboxItem;
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

  @Override
  public void itemStateChanged(ItemEvent e) {
  }
}

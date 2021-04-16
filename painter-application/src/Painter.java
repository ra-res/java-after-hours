import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;

public class Painter extends Frame implements ActionListener, MouseMotionListener, MouseListener, ItemListener {
  private static final long serialVersionUID = 1L;
  private FileDialog dialog;
  private MenuBar menubar;
  private Menu menu1, menu2, menu3;
  private MenuItem newMenuItem, openMenuItem, saveMenuItem, colourMenuItem, exitMenuItem;
  private CheckboxMenuItem linesMenuItem, ellipsesMenuItem, rectanglesMenuItem, roundMenuItem, freehandMenuItem,
      thickMenuItem, shadowMenuItem, textMenuItem, transparentMenuItem, textureMenuItem, gradientMenuItem,
      solidMenuItem, plainMenuItem;
  private BufferedImage bufferedImage, image;
  private int imageHeight, imageWidth;
  private TextDialog textDialog;
  private ImageIO tileImage;

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

    dialog = new FileDialog(this, "File Dialog");
    bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_BGR);

    image = createImage(imageWidth, imageHeight);
    textDialog = new OkCancelDialog(this, "Enter your text", true);
    try {
      File inputFile = new File("tile.jpg");
      tileImage = ImageIO.read(inputFile);
    } catch (java.io.IOException ioe) {
      System.out.println("Need tile.jpg.");
      System.exit(0);
    }
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setSize(400, 400);
    setTitle("Painter");
    setVisible(true);
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

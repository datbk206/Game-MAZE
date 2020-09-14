import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MapUI extends JComponent {
	private int x, y;
	public Map map;
	public MapUI(int a, int b) {
		this.x = a + 2;
		this.y = b + 2;
		map = new Map(x, y);
		
		ImageIcon icon[] = new ImageIcon[3];
		icon[2] = new ImageIcon("src/wall.png");
		icon[1] = new ImageIcon("src/road.png");
		icon[0] = new ImageIcon("src/door.png");
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				JLabel jlb = new JLabel(icon[map.value[i][j]]);
				jlb.setBounds(i * 50, j * 50, 50, 50);
				add(jlb);
			}
		}
		setSize(x * 50 + 16 , y * 50 + 38);
		
	}
}

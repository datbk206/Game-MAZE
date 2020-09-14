import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MAZEUI extends JFrame {
	private int x, y, player_x, player_y;
	public MAZEUI(int a) {
		setTitle("MAZE");
		x = 0;
		y = 0;
		player_x = 50;
		player_y = 50;
		JLabel player = new JLabel(new ImageIcon("src/player.png"));
		player.setBounds(10 + player_x,10 + player_y,50,50);
		add(player);
		MapUI mapUI = new MapUI(a * 5, a* 5);
		mapUI.setBounds(10 + x, 10 + y, a * 250 + 116, a * 250 + 138);
		add(mapUI);
		addKeyListener(new KeyListener() {
			int prev_x, prev_player_x, prev_y, prev_player_y;
			public void keyPressed(KeyEvent e) {	
				prev_x = x;
				prev_player_x = player_x;
				prev_y = y;
				prev_player_y = player_y;
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					if(player_x == 100) {
						x += 50;
					}else {
						player_x -= 50;
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if(player_x  == 200) {
						x -= 50;
					}else {
						player_x += 50;
					}
					
				}
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					if(player_y == 100) {
						y += 50;
					}else {
						player_y -= 50;
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(player_y  == 200) {
						y -= 50;
					}else {
						player_y += 50;
					}
				}
				checkPlayerPosition();
				player.setBounds(10 + player_x,10 + player_y,50,50);
				mapUI.setBounds(10 + x, 10 + y, a * 250 + 116, a * 250 + 138);
			}

			private void checkPlayerPosition() {
				int playerPosX = (player_x - x) / 50; 
				int playerPosY = (player_y - y) / 50;
				switch(mapUI.map.value[playerPosX][playerPosY]) {
				case 2: //wall
					x = prev_x;
					player_x = prev_player_x;
					y = prev_y;
					player_y = prev_player_y;
					break;
				case 0: // door
					System.out.println("YOU WIN!");
					new MAZEUI(a+1);
					dispose();
				}
			}

			public void keyReleased(KeyEvent e) {
				
			}

			public void keyTyped(KeyEvent e) {
				
			}
		});
		
		setSize(1080, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);  
		setVisible(true);
	}
}

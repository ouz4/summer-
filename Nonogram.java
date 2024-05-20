import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sxt.data.NonogramGame;
import com.sxt.swing.pubilc;


public class Nonogram extends JPanel {
   private final int ROWS =5;
    private final int COLS =5;
    public Nonogram(){
        setLayout(new GridLayout(ROWS, COLS));

        JButton[][] cells = new JButton[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                JButton cell = new JButton();
                cell.setPreferredSize(new Dimension(50, 50));
                cell.setBackground(Color.WHITE);
                cell.addActionListener(new CellClickListener(i, j));
                 add(cell);
                cells[i][j] = cell;
            }
        }


    }


   
    

        class CellClickListener implements ActionListener {
           private int row=0;
            private int col=0;
            
            
        
        public CellClickListener(int row,int col){
            this.row = row;
            this.col = col;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedCell =(JButton) e.getSource();
            Color currentColor = clickedCell.getBackground();

            // 根据当前颜色切换方块的状态
            if (currentColor == Color.WHITE) {
                clickedCell.setBackground(Color.GRAY); // 未知颜色
            } else if (currentColor == Color.GRAY) {
                clickedCell.setBackground(Color.BLACK); // 黑色
            } else {
                clickedCell.setBackground(Color.WHITE); // 白色
            }
        }
    
     
        
    }public static void main(String[] args) {
        Nonogram nonogram = new Nonogram();
        
            JFrame frame = new JFrame("Nonogram");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
             frame.getContentPane().add(nonogram);

            frame.setSize(800,600);} 
}
    

    
   
   
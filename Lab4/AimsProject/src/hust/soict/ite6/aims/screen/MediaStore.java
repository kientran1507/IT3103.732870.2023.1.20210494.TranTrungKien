package hust.soict.ite6.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import hust.soict.ite6.aims.cart.Cart;
import hust.soict.ite6.aims.exception.PlayerException;
import hust.soict.ite6.aims.media.Media;
import hust.soict.ite6.aims.media.Playable;

public class MediaStore extends JPanel{
	private Media media;
	private Cart cart;
	public MediaStore(Media media) {
		
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.addMedia(media);
            }
        });
        container.add(addToCartButton);
        
        JDialog playDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Media Player", true);
        JLabel mediaLabel = new JLabel("Playing: " + media.getTitle());
        mediaLabel.setHorizontalAlignment(JLabel.CENTER);
        playDialog.add(mediaLabel);

        playDialog.setSize(400, 300);
        playDialog.setLocationRelativeTo(this);
        playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ((Playable) media).play();
                    } catch (PlayerException pe) {
                        JOptionPane.showMessageDialog(container, "Error playing media: " + pe.getMessage(), "Playback Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            container.add(playButton);
        }
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}

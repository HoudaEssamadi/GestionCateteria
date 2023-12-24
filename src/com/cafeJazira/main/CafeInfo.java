package com.cafeJazira.main;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.cafeJazira.metier.IMetierImp;
import com.cafeJazira.model.Cafe;

public class CafeInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CafeInfo frame = new CafeInfo();
					frame.setSize(900, 455); // Définir la taille initiale du cadre
			        frame.setResizable(false); // Empêcher la redimension du cadre
			       // frame.pack(); // Ajuster la taille du cadre en fonction du contenu
			        frame.setLocationRelativeTo(null); // Centrer le cadre sur l'écran
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CafeInfo() {
		 IMetierImp metier = new IMetierImp();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 457);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setLocation(131, 10);
		panel.setSize(744, 398);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion du cafétéria");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(288, 11, 192, 44);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Produit");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(63, 79, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom");
		lblNewLabel_1_1.setForeground(Color.ORANGE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(63, 126, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Categorie");
		lblNewLabel_1_2.setForeground(Color.ORANGE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(63, 179, 68, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quantité");
		lblNewLabel_1_3.setForeground(Color.ORANGE);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(435, 79, 59, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Prix");
		lblNewLabel_1_4.setForeground(Color.ORANGE);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(435, 134, 46, 14);
		panel.add(lblNewLabel_1_4);
		
		TextField textProduit = new TextField();
		textProduit.setBounds(192, 71, 164, 22);
		panel.add(textProduit);
		
		TextField txtNom = new TextField();
		txtNom.setBounds(192, 118, 164, 22);
		panel.add(txtNom);
		
		TextField txtQt = new TextField();
		txtQt.setBounds(577, 71, 145, 22);
		panel.add(txtQt);
		
		TextField txtPrix = new TextField();
		txtPrix.setBounds(577, 126, 145, 22);
		panel.add(txtPrix);
		
		JComboBox cmbCate = new JComboBox();
		cmbCate.setBackground(SystemColor.inactiveCaptionBorder);
		cmbCate.setForeground(Color.ORANGE);
		cmbCate.setModel(new DefaultComboBoxModel(new String[] {"Choisir", "Café Arabica", "Café Robusta", "Café Décaféiné"}));
		cmbCate.setBounds(192, 175, 121, 22);
		panel.add(cmbCate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 246, 428, 109);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.ORANGE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Produit", "Nom", "Categorie", "Quantite", "Prix"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		// Ajoutez un écouteur de sélection à la JTable
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                // Récupérez les données de la ligne sélectionnée
            	String produit = (String) table.getValueAt(selectedRow, 1);
            	String nom = (String) table.getValueAt(selectedRow, 2);
            	String categorie = (String) table.getValueAt(selectedRow, 3);
            	String quantite = table.getValueAt(selectedRow, 4).toString();
                String prix = table.getValueAt(selectedRow, 5).toString();
                

                // Affichez les données dans les zones de texte
                textProduit.setText(produit);
                txtNom.setText(nom);
                txtQt.setText(quantite);
                txtPrix.setText(prix);
                cmbCate.setSelectedItem(categorie);
            }
        });
		
		
     // Modifiez le bouton de modification pour effectuer la modification
        JButton btnModifier = new JButton("Modifier");
        btnModifier.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                // Récupérez l'ID de la ligne sélectionnée
                int id = (int) table.getValueAt(selectedRow, 0);

                // Modifiez l'objet Cafe avec les nouvelles valeurs
                Cafe cafe = new Cafe();
                cafe.setId(id);
                cafe.setProduit(textProduit.getText());
                cafe.setNom(txtNom.getText());
                cafe.setQuantite(txtQt.getText());
                cafe.setPrix(txtPrix.getText());
                cafe.setCategorie((String) cmbCate.getSelectedItem());

                // Appelez la méthode de modification dans votre couche métier
                boolean modificationReussie = metier.update(cafe);

                if (modificationReussie) {
                    System.out.println("Modification réussie !");
                    // Actualisez la table après la modification
                    updateTableData();
                } else {
                    System.out.println("Échec de la modification.");
                }
            }
        });
        
		btnModifier.setForeground(Color.ORANGE);
		btnModifier.setBackground(SystemColor.inactiveCaptionBorder);
		btnModifier.setBounds(22, 141, 89, 23);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

	            if (selectedRow >= 0) {
	                int idToDelete = (int) table.getValueAt(selectedRow, 0);

	                // Créez un objet Cafe avec seulement l'ID
	                Cafe cafeToDelete = new Cafe();
	                cafeToDelete.setId(idToDelete);

	                // Appelez la méthode de suppression dans votre couche métier
	                boolean suppressionReussie = metier.delete(cafeToDelete);

	                if (suppressionReussie) {
	                    System.out.println("Suppression réussie !");
	                    // Actualisez la table après la suppression
	                    updateTableData();
	                } else {
	                    System.out.println("Échec de la suppression.");
	                }
	            } else {
	                System.out.println("Aucune ligne sélectionnée.");
	            }
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSupprimer.setForeground(Color.ORANGE);
		btnSupprimer.setBackground(SystemColor.inactiveCaptionBorder);
		btnSupprimer.setBounds(22, 204, 89, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnVider = new JButton("Vider");
		btnVider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 textProduit.setText("");
		            txtNom.setText("");
		            txtQt.setText("");
		            txtPrix.setText("");
		            cmbCate.setSelectedIndex(0); // Remettre le JComboBox à la première option
			}
		});
		btnVider.setForeground(Color.ORANGE);
		btnVider.setBackground(SystemColor.inactiveCaptionBorder);
		btnVider.setBounds(22, 262, 89, 23);
		contentPane.add(btnVider);
		
		JButton btnModifier_1 = new JButton("Modifier");
		btnModifier_1.setBounds(22, 141, 89, 23);
		contentPane.add(btnModifier_1);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        IMetierImp metier = new IMetierImp();
		        String produit = textProduit.getText();  
		        String nom = txtNom.getText();
		        String categorie = (String) cmbCate.getSelectedItem();
		        String quantite = txtQt.getText();
		        String prix = txtPrix.getText();
		        Cafe cafe = new Cafe(produit, nom, categorie, quantite, prix);

		        boolean ajoutReussi = metier.create(cafe);

		        if (ajoutReussi) {
		            System.out.println("Café ajouté avec succès !");
		        } else {
		            System.out.println("Échec de l'ajout du café.");
		        }
		    }
		});

		btnAjouter.setForeground(Color.ORANGE);
		btnAjouter.setBackground(SystemColor.inactiveCaptionBorder);
		btnAjouter.setBounds(22, 81, 89, 23);
		contentPane.add(btnAjouter);
		updateTableData();
	}
	

	private void updateTableData() {
		 IMetierImp metier = new IMetierImp();
        List <Cafe> cafes = metier.getAll();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Pour effacer les lignes existantes dans le modèle

        for (Cafe cafe : cafes) {
            Object[] row = {
                    cafe.getId(),
                    cafe.getProduit(),
                    cafe.getNom(),
                    cafe.getCategorie(),
                    cafe.getQuantite(),
                    cafe.getPrix()
                   
            };
            model.addRow(row);
        }
    }
	
}

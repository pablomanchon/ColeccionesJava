package Servicios;

import Entidades.Pelicula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Metodos {
    private JTextField peliculaPanel;
    private JTextField autorPanel;
    private JTextField duracionPanel;
    private JPanel panel;
    private JButton quitarPeli;
    private JButton agregarPeli;
    private JTextArea peliculasPanel;

    ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();

    public Metodos() {
        crearPelicula();


    }

    private void crearPelicula() {
        agregarPeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = peliculaPanel.getText();
                    String autor = autorPanel.getText();
                    Double duracion = Double.parseDouble(duracionPanel.getText());

                    Pelicula pelicula = new Pelicula(nombre, autor, duracion);
                    peliculas.add(pelicula);
                    peliculasPanel.setText(peliculasPanel.getText() + "\n" + pelicula.toString());

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Las horas deben ser con numeros");
                    duracionPanel.setText(null);
                }
            }
        });
    }

    public void inciarVentana() {
        JFrame frame = new JFrame("Peliculas");
        frame.setContentPane(new Servicios.Metodos().panel);
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

package cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * Panel para mostrar la conversación y pedir al usuario el 
 * texto que quiere enviar.
 */
public class PanelCliente
{
    /** Scroll */
    private JScrollPane scroll;

    /** Area para mostrar la conversación */
    private JTextArea textArea;

    /** Para pedir el texto al usuario */
    private JTextField textField;

    /** Botón para enviar el texto */
    private JButton boton;

    /**
     * Crea el panel con todos sus componentes. 
     * Un Area de texto para ver la conversación, un textField para 
     * escribir el texto que queremos enviar y un botón de enviar.
     * 
     * @param contenedor
     *            Contenedor en el que añadir todos los componentes
     */
    public PanelCliente(Container contenedor)
    {
        contenedor.setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.orange);
        scroll = new JScrollPane(textArea);

        JPanel panel = new JPanel(new FlowLayout());
        {
        	textField = new JTextField(50);
        	panel.add(textField);
        }
        {
        	boton = new JButton("Enviar");
        	panel.add(boton);
        }
        
        contenedor.add(scroll, BorderLayout.CENTER);
        contenedor.add(panel, BorderLayout.SOUTH);
    }

    /** Añade el actionListener que se le pasa tanto al pulsar 
     * <intro> en el textField como al botón.
     * @param accion ActionListener a añadir.
     */
    public void addActionListener(ActionListener accion)
    {
        textField.addActionListener(accion);
        boton.addActionListener(accion);

    }

    /**
     * Añade el texto que se le pasa al textArea.
     * @param texto Texto a añadir
     */
    public void addTexto(String texto)
    {
        textArea.append(texto);
    }

    /**
     * Devuelve el texto que hay en el textfield y lo borra.
     * @return El texto del textfield.
     */
    public String getTexto()
    {
        String texto = textField.getText();
        textField.setText("");
        return texto;
    }
}

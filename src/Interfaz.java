import javax.security.auth.Refreshable;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Interfaz extends JFrame  {

    private JTextArea  textArea1;
    private JPanel webPanel;
    private JButton buttonIr;
    private JButton buttonB;
    private JButton buttonF;

    private Stack<String> Paginas = new Stack<>();
    private Stack<String> PaginasVistas = new Stack<>();

    public Interfaz() {
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               BAction();


            }
        });

        buttonIr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addIrToStack();

            }
        });
        buttonF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FWebToSatck();

            }
        });

        buttonB.setEnabled(false);
        buttonF.setEnabled(false);

    }

    private void FWebToSatck() {
        if(PaginasVistas.empty()){
            buttonF.setEnabled(false);
            return;
        }
        Paginas.push(PaginasVistas.pop());
    }

    private void addIrToStack() {

        Paginas.push("Url #"+Paginas.size());
        PaginasVistas.clear();

        buttonB.setEnabled(true);
        buttonF.setEnabled(false);
    }

    private void BAction() {
        if(Paginas.empty())
            return;

        PaginasVistas.push(Paginas.pop());
        buttonF.setEnabled(true);

        if(Paginas.empty())
            buttonB.setEnabled(false);
    }

    public JPanel getWebPanel() {
        return webPanel;
    }
}

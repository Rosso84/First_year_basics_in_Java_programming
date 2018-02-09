import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyCalculator extends JFrame implements ActionListener {

    private JTextField txtNOK, txtOther;
    private JButton btnRensOther, btnRens, btnRensNOK, btnAvbryt, btnUSD, btnGBP, btnEUR, btnSEK;
    private JPanel pnlNorth = new JPanel(new GridLayout(2, 2));
    private JLabel valutaOther;
    private JLabel valutaNOK = new JLabel("NOK");
    private double sek = 1.03D;
    private double gbp = 0.09D;
    private double eur = 0.1D;
    private double usd = 0.11D;
    private double belop;
    private double sum;

    public CurrencyCalculator() {

        super("Valuta Kalkulator");
        this.pnlNorth.add(this.valutaNOK);
        this.valutaOther = new JLabel("Annen");
        this.pnlNorth.add(this.valutaOther);
        this.txtNOK = new JTextField();
        this.txtOther = new JTextField();
        this.pnlNorth.add(this.txtNOK);
        this.pnlNorth.add(this.txtOther);
        this.add(this.pnlNorth, "North");
        JPanel pnlSouth = new JPanel(new GridLayout(1, 4));
        this.add(pnlSouth, "South");
        this.btnRensNOK = new JButton("Fjern NOK");
        this.btnRensNOK.addActionListener(this);
        pnlSouth.add(this.btnRensNOK);
        this.btnRensOther = new JButton("Fjern annen");
        this.btnRensOther.addActionListener(this);
        pnlSouth.add(this.btnRensOther);
        this.btnRens = new JButton("Fjern begge");
        this.btnRens.addActionListener(this);
        pnlSouth.add(this.btnRens);
        this.btnAvbryt = new JButton("Avslutt");
        this.btnAvbryt.addActionListener(this);
        pnlSouth.add(this.btnAvbryt);
        JPanel pnlCenter = new JPanel(new GridLayout(2, 2));
        this.add(pnlCenter, "Center");
        this.btnUSD = new JButton("USD");
        this.btnUSD.addActionListener(this);
        pnlCenter.add(this.btnUSD);
        this.btnGBP = new JButton("GBP");
        this.btnGBP.addActionListener(this);
        pnlCenter.add(this.btnGBP);
        this.btnEUR = new JButton("EUR");
        this.btnEUR.addActionListener(this);
        pnlCenter.add(this.btnEUR);
        this.btnSEK = new JButton("SEK");
        this.btnSEK.addActionListener(this);
        pnlCenter.add(this.btnSEK);
        this.setSize(600, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);

    }

    public void showCurrencySEK() {
        this.valutaOther.setText("SEK");
        String x = this.txtNOK.getText();
        this.belop = Double.parseDouble(x);
        this.sum = this.belop * this.sek;
        this.txtOther.setText(Double.toString(this.sum));
    }

    public void showCurrencyUSD() {
        this.valutaOther.setText("USD");
        String x = this.txtNOK.getText();
        this.belop = Double.parseDouble(x);
        double sum = this.belop * this.usd;
        this.txtOther.setText(Double.toString(sum));
    }

    public void showCurrencyGBP() {
        this.valutaOther.setText("GBP");
        String x = this.txtNOK.getText();
        this.belop = Double.parseDouble(x);
        double sum = this.belop * this.gbp;
        this.txtOther.setText(Double.toString(sum));
    }

    public void showCurrencyEUR() {
        this.valutaOther.setText("EUR");
        String x = this.txtNOK.getText();
        this.belop = Double.parseDouble(x);
        double sum = this.belop * this.eur;
        this.txtOther.setText(Double.toString(sum));
    }

    public void errorEmptyBoth() {
        if (this.txtNOK.getText().isEmpty() && this.txtOther.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Et av feltene må fylles");
        }

    }

    public void errorFilledBoth() {
        if (!this.txtNOK.getText().isEmpty() && !this.txtOther.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Begge felt kan ikke være fylt");
        }

    }



    public void actionPerformed(ActionEvent e) {

        Object buttonPress = e.getSource();
        if (buttonPress == this.btnSEK) {
            this.txtOther.setText("");
            this.errorEmptyBoth();
            this.errorFilledBoth();
            this.showCurrencySEK();
        } else if (buttonPress == this.btnUSD) {
            this.txtOther.setText("");
            this.errorFilledBoth();
            this.errorEmptyBoth();
            this.showCurrencyUSD();
        } else if (buttonPress == this.btnGBP) {
            this.txtOther.setText("");
            this.errorFilledBoth();
            this.errorEmptyBoth();
            this.showCurrencyGBP();
        } else if (buttonPress == this.btnEUR) {
            this.txtOther.setText("");
            this.errorFilledBoth();
            this.errorEmptyBoth();
            this.showCurrencyEUR();
        } else if (buttonPress == this.btnRensNOK) {
            this.txtNOK.setText("");
        } else if (buttonPress == this.btnRensOther) {
            this.txtOther.setText("");
        } else if (buttonPress == this.btnRens) {
            this.txtNOK.setText("");
            this.txtOther.setText("");
        } else {
            System.exit(0);
        }

    }


}


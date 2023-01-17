package misco;

import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class MiTextoValidante extends JPanel implements FocusListener {

    //Atributos de la clase
    private String tipoValidacion;
    private String errorValidacion;
    JTextField miTexto = new JTextField("");
    JLabel miEtiqueta = new JLabel("Texto etiqueta");

    //Constructor principal
    public MiTextoValidante() {
        Dimension tamanio = new Dimension(200, 50);
        this.setPreferredSize(tamanio);
        this.add(miTexto);
        this.add(miEtiqueta);

        miTexto.addFocusListener(this);
        
        errorValidacion = "Sin errores";
    }

    //Getters y Setters
    public String getTipoValidacion() {
        return tipoValidacion;
    }

    public void setTipoValidacion(String tipoValidacion) {
        this.tipoValidacion = tipoValidacion;
    }

    public String getErrorValidacion() {
        return errorValidacion;
    }

    public void setErrorValidacion(String errorValidacion) {
        this.errorValidacion = errorValidacion;
    }

    //Metodos abstractos del FocusListener
    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        validacion();
    }

    private void validacion() {

        miEtiqueta.setText(errorValidacion);

        if ("TFN".equals(this.tipoValidacion)) {
            if (miTexto.getText().length() != 9) {
                errorValidacion = "El TFN debe tener 9 digitos.";
            } else {
                errorValidacion = "TFN correcto.";
            }
        }
    } // fin validacion
}

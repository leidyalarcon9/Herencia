/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import javax.swing.JOptionPane;

/**
 *
 * @author paipo
 */
public class Estudiante extends Persona {
    
    protected String carnet;
    protected double promedioNotas;
    protected int numeroMaterias;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, int edad, int peso, String carnet, double promedioNotas, int numeroMaterias) {
        
        super(nombre, apellido, edad, peso);
        
        this.carnet = carnet;
        this.promedioNotas = promedioNotas;
        this.numeroMaterias = numeroMaterias;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public double getPromedioNotas() {
        return promedioNotas;
    }

    public void setPromedioNotas(double promedioNotas) {
        this.promedioNotas = promedioNotas;
    }

    public int getNumeroMaterias() {
        return numeroMaterias;
    }

    public void setNumeroMaterias(int numeroMaterias) {
        this.numeroMaterias = numeroMaterias;
    }
    
    public double calcularPromedio (double sumatoriaNotas, int numeroMaterias) { 
        
        double promedio;
        
        promedio = (sumatoriaNotas / numeroMaterias);
        
        return promedio;
    }
    
    public double leerNotasEstudiante (int numeroMaterias) {
        
        int cont = 0;
        double promedio, nota, sumatoriaNotas = 0.00;
        String materia;
                
        do{
            
            cont++;
            materia = leerDatoTipoCadena("Ingrese la materia #" + cont);
            nota = leerDatoTipoReal("Ingrese la nota de la materia " + materia);
            sumatoriaNotas = nota + sumatoriaNotas;
            
        }while (cont != numeroMaterias);
        
        promedio = calcularPromedio(sumatoriaNotas, numeroMaterias);
        
        return promedio;
    }
    
    public Estudiante ingresarDatosEstudiante() {
        
        Estudiante nuevoEstudiante = new Estudiante();
        
        String codigo = "";
        String nombre = "";
        String apellido = "";
        
        int edad = 0;
        int numeroMaterias = 0;
        
        double peso = 0.0;
        double promedio = 0.0;
        
        codigo = leerDatoTipoCadena("Ingrese el carnet del estudiante: ");
        nombre = leerDatoTipoCadena("Ingrese el nombre del estudiante: ");
        apellido = leerDatoTipoCadena("Ingrese el apellido del estudiante: ");
        edad = leerDatoTipoEntero("Ingrese la edad del estudiante: ");
        peso = leerDatoTipoReal("Ingrese el peso del estudiante: ");
        numeroMaterias = leerDatoTipoEntero("Ingrese el número de materias inscritas por el estudiante: ");

//Calculamos el promedio
        promedio = leerNotasEstudiante(numeroMaterias);
//Definimos los datos para el constructor
        nuevoEstudiante.setNombre(nombre);
        nuevoEstudiante.setApellido(apellido);
        nuevoEstudiante.setCarnet(codigo);
        nuevoEstudiante.setEdad(edad);
        nuevoEstudiante.setPeso(peso);
        nuevoEstudiante.setPromedioNotas(promedio);
        nuevoEstudiante.setNumeroMaterias(numeroMaterias);

        //Retornamos el objeto
        return (nuevoEstudiante);
    }
    
    public void imprimirReporteEstadoEstudiante() {
        
        //Usamos nuevamente la herencia para llamar los métodos
        //que imprimen los datos del empleado
        
        imprimirDatosPersona();
        
        //Ahora imprimimos los datos propios del estudiante
        JOptionPane.showMessageDialog(null, "El carnet del estudiante es: " + carnet);
        JOptionPane.showMessageDialog(null, "El estudiante cursa " + numeroMaterias + " materias\n"
                                            + "Su promedio es de: " + promedioNotas);
        
    }
    
    
    
    
    
}

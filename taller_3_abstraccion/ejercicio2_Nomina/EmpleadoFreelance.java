
// CONSTRUYE TU MISMO: empleado que cobra por proyecto entregado. Si todavia
// no ha terminado ningun proyecto en el mes, el calculo simplemente da 0,
// sin lanzar ningun error ni necesitar validaciones especiales.
public class EmpleadoFreelance extends Empleado {

    private final int proyectosTerminados;
    private final double pagoPorProyecto;

    public EmpleadoFreelance(String nombre, String documento, int proyectosTerminados, double pagoPorProyecto) {
        super(nombre, documento);
        this.proyectosTerminados = proyectosTerminados;
        this.pagoPorProyecto = pagoPorProyecto;
    }

    public int getProyectosTerminados() {
        return proyectosTerminados;
    }

    public double getPagoPorProyecto() {
        return pagoPorProyecto;
    }

    @Override
    public double calcularPago() {
        return proyectosTerminados * pagoPorProyecto;
    }
}

/**
 * Estado Concreto: Emergência
 * Estado terminal.
 * * DECISÃO DE DESIGN:
 * Este estado não permite NENHUMA ação ou transição para fora.
 * Ele herda o comportamento "ação inválida" do EstadoBase para 
 * todos os métodos.
 */
public class EmergenciaEstado extends EstadoBase {
    
    public EmergenciaEstado() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("!!! ESTADO DE EMERGÊNCIA ATIVADO. EVACUAR ÁREA. !!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    // Nenhuma ação é sobrescrita. Todas as ações são inválidas.
}
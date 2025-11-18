/**
 * Estado Concreto: Desligada
 * A usina está fria e inerte.
 */
public class DesligadaEstado extends EstadoBase {

    @Override
    public void iniciar(UsinaNuclear usina) {
        // Ação VÁLIDA: Inicia a usina e muda o estado para Normal
        System.out.println("[AÇÃO] Iniciando reator. Aquecendo para 250°C.");
        usina.setTemperaturaReator(250.0);
        usina.setEstado(usina.getOperacaoNormalEstado());
    }

    @Override
    public void iniciarManutencao(UsinaNuclear usina) {
        // Ação VÁLIDA: Entra em manutenção
        System.out.println("[AÇÃO] Entrando em modo de manutenção a partir do estado DESLIGADA.");
        // Configura o estado de retorno
        usina.getManutencaoEstado().setEstadoAnterior(this);
        usina.setEstado(usina.getManutencaoEstado());
    }
}
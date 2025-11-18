/**
 * Estado Concreto: Operação Normal
 * A usina está funcionando. Este estado monitora ativamente os sensores.
 */
public class OperacaoNormalEstado extends EstadoBase {

    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        // REGRA 1: OPERACAO_NORMAL -> ALERTA_AMARELO
        if (usina.getTemperaturaReator() > 300) {
            System.out.println("[ALERTA] Temperatura > 300°C! Risco detectado.");
            usina.setEstado(usina.getAlertaAmareloEstado());
        }
    }

    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("[AÇÃO] Iniciando procedimento de desligamento...");
        usina.setTemperaturaReator(25.0);
        usina.setEstado(usina.getDesligadaEstado());
    }

    @Override
    public void iniciarManutencao(UsinaNuclear usina) {
        System.out.println("[AÇÃO] Pausando operações para manutenção.");
        // Configura o estado de retorno
        usina.getManutencaoEstado().setEstadoAnterior(this);
        usina.setEstado(usina.getManutencaoEstado());
    }
}
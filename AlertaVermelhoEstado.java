/**
 * Estado Concreto: Alerta Vermelho
 * Estado crítico. A única saída é a EMERGÊNCIA ou o desligamento.
 * * APLICANDO REGRA (Unidirecional):
 * Este é o ÚNICO estado que pode transicionar para EMERGENCIA.
 */
public class AlertaVermelhoEstado extends EstadoBase {

    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        // REGRA 3: ALERTA_VERMELHO -> EMERGENCIA
        if (!usina.isSistemaResfriamentoOK()) {
            System.out.println("[PERIGO] FALHA CRÍTICA NO SISTEMA DE RESFRIAMENTO!");
            usina.setEstado(usina.getEmergenciaEstado());
        }
        
        // REGRA (Bidirecional): Pode voltar para Amarelo se a temp baixar
        else if (usina.getTemperaturaReator() <= 400) {
             System.out.println("[INFO] Perigo contido. Retornando ao Alerta Amarelo.");
             usina.setEstado(usina.getAlertaAmareloEstado());
        }
    }
    
    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("[AÇÃO] SCRAM! Desligamento de emergência total!");
        usina.setTemperaturaReator(25.0);
        usina.setEstado(usina.getDesligadaEstado());
    }
}
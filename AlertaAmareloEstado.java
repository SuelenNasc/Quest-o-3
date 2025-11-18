/**
 * Estado Concreto: Alerta Amarelo
 * Monitora se a situação piora ou melhora.
 */
public class AlertaAmareloEstado extends EstadoBase {

    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        // REGRA 2: ALERTA_AMARELO -> ALERTA_VERMELHO
        // (Simplificando "30 segundos" para uma verificação imediata)
        if (usina.getTemperaturaReator() > 400) {
            System.out.println("[ALERTA] Temperatura > 400°C! Nível de perigo elevado.");
            usina.setEstado(usina.getAlertaVermelhoEstado());
        
        // REGRA (Bidirecional): Retorno ao normal
        } else if (usina.getTemperaturaReator() <= 300) {
            System.out.println("[INFO] Temperatura estabilizada. Retornando à Operação Normal.");
            usina.setEstado(usina.getOperacaoNormalEstado());
        }
    }

    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("[AÇÃO] Iniciando desligamento de emergência leve...");
        usina.setTemperaturaReator(25.0);
        usina.setEstado(usina.getDesligadaEstado());
    }
    
    // DECISÃO DE DESIGN: Não é permitido iniciar manutenção 
    // durante um alerta. A ação é inválida (herdada do EstadoBase).
}
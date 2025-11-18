/**
 * Classe Cliente (Main) para demonstrar o Padrão State.
 * Simula a passagem do tempo e mudanças nos sensores,
 * pedindo à usina para verificar suas condições.
 */
public class Main {
    public static void main(String[] args) {
        
        System.out.println("===== SIMULAÇÃO 1: Fluxo de Emergência =====");
        UsinaNuclear usina1 = new UsinaNuclear();
        
        // 1. Inicia
        usina1.iniciar();
        
        // 2. Temp sobe -> Amarelo
        usina1.setTemperaturaReator(350.0);
        usina1.verificarCondicoes();
        
        // 3. Temp sobe mais -> Vermelho
        usina1.setTemperaturaReator(410.0);
        usina1.verificarCondicoes();
        
        // 4. Temp baixa -> Amarelo (Teste Bidirecional)
        usina1.setTemperaturaReator(380.0);
        usina1.verificarCondicoes();
        
        // 5. Temp sobe de novo -> Vermelho
        usina1.setTemperaturaReator(420.0);
        usina1.verificarCondicoes();

        // 6. Tenta iniciar manutenção (inválido)
        usina1.iniciarManutencao();

        // 7. Resfriamento falha -> Emergência
        usina1.setSistemaResfriamentoOK(false);
        usina1.verificarCondicoes();
        
        // 8. Tenta desligar (inválido em emergência)
        usina1.desligar();


        System.out.println("\n\n===== SIMULAÇÃO 2: Fluxo de Manutenção =====");
        UsinaNuclear usina2 = new UsinaNuclear();
        
        // 1. Inicia
        usina2.iniciar();
        
        // 2. Temp sobe -> Amarelo
        usina2.setTemperaturaReator(310.0);
        usina2.verificarCondicoes();
        
        // 3. Tenta entrar em manutenção (inválido em alerta)
        usina2.iniciarManutencao();
        
        // 4. Temp baixa -> Normal
        usina2.setTemperaturaReator(290.0);
        usina2.verificarCondicoes();
        
        // 5. Entra em manutenção (válido em modo normal)
        usina2.iniciarManutencao();
        
        // 6. Temp sobe, mas nada acontece (estado de manutenção)
        usina2.setTemperaturaReator(500.0);
        usina2.verificarCondicoes();
        
        // 7. Finaliza manutenção (retorna ao estado anterior: Normal)
        usina2.finalizarManutencao();

        // 8. Agora que voltou, a verificação de condição reage!
        // A temperatura (500) é lida e vai direto para Amarelo e Vermelho.
        usina2.verificarCondicoes(); // Deve ir para Amarelo
        usina2.verificarCondicoes(); // Deve ir para Vermelho
    }
}
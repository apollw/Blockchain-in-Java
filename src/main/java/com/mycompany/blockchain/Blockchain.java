package com.mycompany.blockchain;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    
    private List<Block> chain;
    
    public Blockchain(){
    
            chain = new ArrayList<Block>();
            chain.add(gerarGenesis()); //Gerar bloco Genesis, adicionando
            //o bloco Genesis à cadeia/corrente
    }
    
    private Block gerarGenesis(){
    
        Block genesis = new Block("0x200", new java.util.Date(),"<transaçoes>");
        genesis.setHashAnterior(null);
        genesis.calcularHash();
        return genesis;    
    }
    
    public void adicionarBloco(Block bloco){
        Block novoBloco = bloco;
        novoBloco.setHashAnterior(chain.get(chain.size()-1).getHash());
        novoBloco.calcularHash();
        this.chain.add(novoBloco);
    }
    
    public void exibirChain(){
    
       for(int i=0;i<chain.size();i++){
           System.out.println("Bloco: "+i);
           System.out.println("Versao: "+chain.get(i).getVersao());
           System.out.println("Timestamp: "+chain.get(i).getTimestamp());
           System.out.println("Hash Anterior: "+chain.get(i).getHashAnterior());
           System.out.println("Hash: "+chain.get(i).getHash());
           System.out.println("");       
       }   
    }
    
    public Block retornarUltimoBloco(){
        return this.chain.get(chain.size()-1);    
    }
    
    public void ehValido(){
        
        for(int i=chain.size()-1;i>0;i--){
            if(  !(chain.get(i)).getHash().equals(chain.get(i).calcularHash())  ){
                System.out.println("A cadeia eh invalida");
                return;
            }
            if(  !(chain.get(i).getHashAnterior().equals(chain.get(i-1).calcularHash())) ){
                System.out.println("A cadeia eh invalida");
                return;
            }
            System.out.println("A cadeia eh valida");                
        }
    }
    
}

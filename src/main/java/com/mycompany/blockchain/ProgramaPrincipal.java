package com.mycompany.blockchain;
/**
 *
 * @author Leanderson Silva e Carlos Augusto
 */

public class ProgramaPrincipal {

    public static void main(String[] args) {
        
    Blockchain tcpCoin = new Blockchain();
    
    Block a = new Block("0x200", new java.util.Date(),"<transacao>");
    Block b = new Block("0x200", new java.util.Date(),"<transacao>");
    Block c = new Block("0x200", new java.util.Date(),"<transacao>");
    
    tcpCoin.adicionarBloco(a);
    tcpCoin.adicionarBloco(b);
    tcpCoin.adicionarBloco(c);
    
    //Aqui alteramos propositalmente um hash para testar se a cadeia eh valida ou nao
    
    //tcpCoin.retornarUltimoBloco().setHashAnterior("ABCDEFG");
    
    tcpCoin.exibirChain();
    
    tcpCoin.ehValido();
        
    }
    
}

//Firstly, lets take a look at what a block actually looks like.
/*
A Block cna be split into 2 sections:

Header Information and Data Information
The Header information contains specific information about the block and previous
blocks and the Data sections contains information about transactions, but this 
is not always the case.

Header Section: 
    Version
    Timestamp (when the block was created)
    Hash
    PreviousHash
    HashOfMerkelTree
    Nonce

    Go to blockchain.info  for greater detail



*/
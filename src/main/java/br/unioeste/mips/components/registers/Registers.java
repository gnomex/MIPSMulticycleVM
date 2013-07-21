package br.unioeste.mips.components.registers;

import java.util.ArrayList;

import static br.unioeste.mips.util.Util.ZERO;


/**
 * Registers base, 32 regs - 32 bits
 * 
 * @Default regs value: ZERO
 * 	 	
 * – $zero (0) : Guarda a constante 0
		– $at (1): Reservado para o montador
		– $v0, $v1 (2, 3): Usado na avaliação de expressões e p/ guardar o resultado da avaliação de uma função
		– $a0, $a1, $a2, $a3 (4, 5, 6, 7) Usado como argumento
		– $t0, $t1, $t2, $t3, $t4, $t5, $t6, $t7 (8, 9, 10, 11, 12, 13,14, 15): Armazena valores temporários (seus valores
		não precisam ser preservados nas chamadas a	procedimento)
		– $s0, $s1, $s2, $s3, $s4, $s5, $s6, $s7 (16, 17,18, 19, 20, 21, 22, 23): Armazena valores
		temporários (seus valores devem ser	preservados nas chamadas a procedimento)
		– $t8, $t9 (24, 25): Armazena valores temporários (seus valores não precisam ser preservados nas chamadas a procedimento)
		– $k0, $k1 (26, 27): Reservado para o Kernel do Sistema Operacional
		– $gp (28): Ponteiro para área global
		– $sp (29): Apontador de pilha
		– $fp (30): Apontador de quadro
		– $ra (31): Endereço de retorno(usado nas chamadas a procedimento
		
 * */

public class Registers {

	private ArrayList<Register> dataregister;
	
	private Boolean regWrite	=	new Boolean(Boolean.FALSE);	//Default
	
	private Integer RS	=	ZERO;	//Read Register 1
	private Integer RD	=	ZERO;	//WriteRegister
	private Integer RT	=	ZERO;	//Read Register 2
	
	//private Logger logger = Logger.getLogger(Registers.class);
	
	
	public Registers()	{
		dataregister	=	new ArrayList<Register>();
		this.__initRegister();
		
		//logger.setLevel(Level.INFO);
		//logger.info("Initializing Regs base");
		
	}
	
	
	public void setRS(Integer rS) {
		RS = rS;
	}

	public void setRD(Integer rD) {
		RD = rD;
	}

	public void setRT(Integer rT) {
		RT = rT;
	}

	public void setWriteData(Integer value)	{
		
		Register reg = dataregister.get(this.RD);
		reg.setValue(value);
		
		dataregister.add(this.RD, reg);
		
	}

	public Integer getALUOp1(){
		return dataregister.get(this.RS).getValue();
	}
	
	public Integer getALUOp2(){
		return dataregister.get(this.RT).getValue();
	}
	

	private void __initRegister()	{
		
		try{
			
			for(int i=0; i<32; i++)	{
				Register reg	=	new Register();
				reg.setName("$[ " + i + " ]");
				reg.setValue(ZERO);	//Default value
				reg.setWritePermission(Boolean.FALSE);
				
				dataregister.add(reg);		
			}
			
			//logger.info("Regs initializate!");
			
		}catch (Exception e) {
			//logger.error("Error: " + e.getMessage());	//Logger the error	
		}	
	}
	
}

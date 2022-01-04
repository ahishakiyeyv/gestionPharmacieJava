package controller;

import java.sql.*;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.*;


public class Factory {
	
	
	

    static Connection conn;
   static Statement st;
   static PreparedStatement ps;
   static ResultSet rs;
   public static ArrayList<Utilisateur> getUtilisateur()throws Exception
   {
       ArrayList<Utilisateur> util1 = new ArrayList();
       try
       {
        conn=ConnectDb.getConnection();
        String query="select*from Utilisateur";
        st = conn.createStatement();
        rs=st.executeQuery(query);
        Utilisateur util= null;
        
        while(rs.next())
        {
       	 util = new Utilisateur();
       	util.setIdUti(rs.getInt("idUti"));
       	util.setNomUti(rs.getString("nomUti"));
             
             util.setAdrUti(rs.getString("adrUti"));
             util.setTelUti(rs.getInt("telUti"));
             
             util.setPswdUti(rs.getString("pswdUti"));
            // util.setTypeUti(rs.getString("	typeUti")); 
 
           //  util.setLoginUti(rs.getString("loginUti"));
             util1.add(util);
				
			
         //     sc.getNomUtilisateur();
       
        }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       return util1;
       
   }
  
 public static void inSertUtilisateur(Utilisateur util) throws Exception
 {
     String query="insert into utilisateur(nomUti,adrUti,telUti,usernameUti,pswdUti,idetatStock) values (?,?,?,?,?,?)";
    conn=ConnectDb.getConnection();
     ps=conn.prepareStatement(query);

     String nom = util.getNomUti();
     String address = util.getAdrUti();
     String Login = util.getLoginUti();
     int tel = util.getTelUti();
    
    
    
     ps.setString(1, nom);
     ps.setString(2, address);
     ps.setString(3, Login);
     ps.setInt(4, tel);
     
     
      
     ps.executeUpdate();
     conn.close();
 }
 public static void modifierUtilisateur(Utilisateur util)throws Exception
 {
     String query="update Utilisateur set nomutil_Utilisateur=?,adresSoc_Utilisateur=?,"
             + "persContact_Utilisateur=?,tauxPriseSoc_Utilisateur=? "
             + "where idSoc_Utilisateur = ?";
             
    conn=ConnectDb.getConnection();
     ps=conn.prepareStatement(query);
     ps.setString(1, util.getPswdUti());
    // ps.setInt(2, util.getIdSoc());
     
     ps.setString(2, util.getTypeUti());
     ps.setInt(3, util.getEtatstock_idstock());
     ps.setFloat(4, util.getTelUti()); 
     ps.setString(5, util.getAdrUti()); 
     
     
     ps.executeUpdate();
     conn.close();

 }
 public static ArrayList<Utilisateur> rechercherUtilisateur(Utilisateur util)throws Exception
 {
   conn=ConnectDb.getConnection();
    String query="select * from Utilisateur where nomSoc_Utilisateur like  ? "
            + "or adresSoc_Utilisateur like ? or persContact_Utilisateur like ? ";
  ps=conn.prepareStatement(query);
       
       
       ps.setString(1,"%"+ util.getNomUti()+"%");
       ps.setString(2, "%"+util.getAdrUti()+"%");
       ps.setString(3,"%"+ util.getPswdUti()+"%");
       
       ps.setInt(3, util.getEtatstock_idstock());
       
       rs = ps.executeQuery();
       Utilisateur util2 = new Utilisateur();
     ArrayList<Utilisateur> util1 = new ArrayList();
     while(rs.next())
     {
      util2.setIdUti(rs.getInt("idSoc_Utilisateur"));
         //System.out.println(rs.getString("nomSoc_Utilisateur"));
      util2.setNomUti(rs.getString("nomSoc_Utilisateur"));
      util2.setAdrUti(rs.getString("adresSoc_Utilisateur"));
         //System.out.println(util2.getNomSoc());
      util2.setEtatstock_idstock(rs.getInt("tauxPriseSoc_Utilisateur"));
      util2.setLoginUti(rs.getString("persContact_Utilisateur"));
         
      util1.add(util2);
     }
     conn.close();
     
     return util1;
 }
 public static void supprimerUtilisateur(Utilisateur util)throws Exception
 {
     String query="delete from Utilisateur   where idUt= ?";
             
    conn=ConnectDb.getConnection();
     ps=conn.prepareStatement(query);
     ps.setInt(1, util.getIdUti());
     ps.executeUpdate();
     conn.close();
 } 
 ///-------------------end Utilisateur-------------------------------------------------
 
 ////-----------------------begin societe partenaire--------------------
 
 
  public static void tableActualiSoc(Utilisateur util)throws Exception
   {
       try
       {
        conn=ConnectDb.getConnection();
        String query="select*from utilisateur ";
        ps=conn.prepareStatement(query);
        rs=ps.executeQuery();
        ResultSetMetaData rsmd=rs.getMetaData();
        int c=rsmd.getColumnCount();
        while(rs.next())
        {
            util.getNomUti();
            util.getAdrUti();
            util.getLoginUti();
            util.getEtatstock_idstock();
        }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
   }

	
// ============================== produit =============================	
	
	
  public static ArrayList<Produit> getProduit()throws Exception
  {
      ArrayList<Produit> prod1 = new ArrayList();
      try
      {
       conn=ConnectDb.getConnection();
       String query="select*from Produit ";
       st = conn.createStatement();
       rs=st.executeQuery(query);
       Produit prod= null;
       
       while(rs.next())
       {
      	 prod = new Produit();
      	prod.setCodePro(rs.getInt("codePro"));
      	prod.setNomPro(rs.getString("nomPro"));
            
            prod.setDateFabPro(rs.getString("dateFabPro"));
            prod.setDatePerPro(rs.getString("datePerPro"));
            
            prod.setPrixVentePro(rs.getInt("prixVentePro"));
            prod.setCodeFam(rs.getInt("	codeFam")); 

            
            prod1.add(prod);
				
			
        //     sc.getNomProduit();
      
       }
      }
      catch(SQLException e)
      {
          e.printStackTrace();
      }
      return prod1;
      
  }
 
public static void inSertProduit(Produit prod) throws Exception
{
    String query="insert into Produit (nomprod_Produit,adresprod_Produit,	persContact_Produit,tauxPriseprod_Produit) values (?,?,?,?)";
   conn=ConnectDb.getConnection();
    ps=conn.prepareStatement(query);
    
    int codePro = prod.getCodePro();
    String nom = prod.getNomPro();
    String dateFab = prod.getDateFabPro();
    String datePer = prod.getDatePerPro();
    int prixVente = prod.getPrixVentePro();
   
   
    ps.setInt(1, codePro);
    ps.setString(2, nom);
    ps.setString(3, dateFab);
    ps.setString(4, datePer);
    ps.setInt(5, prixVente);
    
    
     
    ps.executeUpdate();
    conn.close();
}
public static void modifierProduit(Produit prod)throws Exception
{
    String query="update produit set nomPro=?,"
            + "dateFabPro=?,datePerPro=?,prixVentePro=?,codeFam=? "
            + "where codePro = ?";
            
    
    // codePro	nomPro	dateFabPro	datePerPro	prixVentePro	codeFam
   conn=ConnectDb.getConnection();
    ps=conn.prepareStatement(query);
    //ps.setInt(, prod.getCodePro());
    
    ps.setString(1, prod.getNomPro());
    ps.setString(2, prod.getDateFabPro());
    ps.setString(3, prod.getDatePerPro()); 
    ps.setInt(4, prod.getPrixVentePro()); 
    ps.setInt(5, prod.getCodeFam());
    ps.setInt(6, prod.getCodePro());
    
    ps.executeUpdate();
    conn.close();

}
public static ArrayList<Produit> rechercherProduit(Produit prod)throws Exception
{
  conn=ConnectDb.getConnection();
   String query="select * from produit where nomPro like  ? "
           + "or dateFabPro like ? or datePerPro like ? ";
 ps=conn.prepareStatement(query);

      
      ps.setString(1,"%"+ prod.getNomPro()+"%");
      ps.setString(2, "%"+prod.getDateFabPro()+"%");
      ps.setString(3,"%"+ prod.getDatePerPro()+"%");
      
     // ps.setInt(3, prod.getEtatstock_idstock());
      
      rs = ps.executeQuery();
      Produit prod2 = new Produit();
    ArrayList<Produit> prod1 = new ArrayList();
  //codePro	nomPro	dateFabPro	datePerPro	prixVentePro	codeFam
    while(rs.next())
    {
     prod2.setCodePro(rs.getInt("codePro"));
        //System.out.println(rs.getString("nomSoc_Produit"));
     prod2.setNomPro(rs.getString("nomPro"));
     prod2.setDateFabPro(rs.getString("dateFabPro"));
        //System.out.println(prod2.getNomSoc());
     prod2.setDatePerPro(rs.getString("datePerPro"));
     prod2.setPrixVentePro(rs.getInt("prixVentePro"));
     prod2.setCodeFam(rs.getInt("codeFam"));
        
     prod1.add(prod2);
    }
    conn.close();
    
    return prod1;
}
public static void supprimerProduit(Produit prod)throws Exception
{
    String query="delete from Produit   where CodePro= ?";
            
   conn=ConnectDb.getConnection();
    ps=conn.prepareStatement(query);
    ps.setInt(1, prod.getCodePro());
    ps.executeUpdate();
    conn.close();
} 
///-------------------tableActualiSoc Produit-------------------------------------------------




 public static void tableActualiSoc(Produit prod)throws Exception
  {
      try
      {
       conn=ConnectDb.getConnection();
       String query="select*from Produit ";
       ps=conn.prepareStatement(query);
       rs=ps.executeQuery();
       ResultSetMetaData rsmd=rs.getMetaData();
       int c=rsmd.getColumnCount();
       while(rs.next())
       {
           prod.getCodePro();
           prod.getNomPro();
           prod.getDateFabPro();
           prod.getDatePerPro();
           prod.getPrixVentePro();
           prod.getCodeFam();
       }
      }
      catch(SQLException e)
      {
          e.printStackTrace();
      }
  }

//=============================== entrer stock  ================================	

 
	
 public static ArrayList<Entreestock> getEntreestock()throws Exception
 {
     ArrayList<Entreestock> entreStoc1 = new ArrayList();
     try
     {
      conn=ConnectDb.getConnection();
      String query="select*from Entreestock ";
      st = conn.createStatement();
      rs=st.executeQuery(query);
      Entreestock entreStoc= null;
      
      while(rs.next())
      {
    	  
    	  //idEntree	prixAchat	qteEntree	codePro
     	 entreStoc = new Entreestock();
     	entreStoc.setIdEntree(rs.getInt("idEntree"));
     	entreStoc.setPrixAchat(rs.getInt("prixAchat"));
           
           entreStoc.setQteEntree(rs.getInt("qteEntree"));
           
           entreStoc.setCodePro(rs.getInt("codePro"));
      

           
           entreStoc1.add(entreStoc);
				
			
       //     sc.getNomEntreestock();
     
      }
     }
     catch(SQLException e)
     {
         e.printStackTrace();
     }
     return entreStoc1;
     
 }

public static void inSertEntreestock(Entreestock entreStoc) throws Exception
{
   String query="insert into Entreestock (prixAchat,qteEntree,codePro) values (?,?,?)";
  conn=ConnectDb.getConnection();
   ps=conn.prepareStatement(query);
   // idEntree	prixAchat	qteEntree	codePro
   int idEntre = entreStoc.getIdEntree();
   int prixAcha = entreStoc.getPrixAchat();
   int qteEntre = entreStoc.getQteEntree();
   int codePro = entreStoc.getCodePro();
   
  
  
   ps.setInt(1, idEntre);
   ps.setInt(2, prixAcha);
   ps.setInt(3, qteEntre);
  // ps.setInt(4, codePro);
  
   
   
    
   ps.executeUpdate();
   conn.close();
}
public static void modifierEntreestock(Entreestock entreStoc)throws Exception
{
   String query="update Entreestock set nomPro=?,"
           + "dateFabPro=?,datePerPro=?,prixVentePro=?,codeFam=? "
           + "where codePro = ?";
           
   
   
  conn=ConnectDb.getConnection();
   ps=conn.prepareStatement(query);
   //ps.setInt(, entreStoc.getCodePro());
   
   ps.setInt(1, entreStoc.getIdEntree());
   ps.setInt(2, entreStoc.getPrixAchat());
   ps.setInt(3, entreStoc.getQteEntree()); 
   ps.setInt(4, entreStoc.getCodePro()); 
  
   
   ps.executeUpdate();
   conn.close();

}
public static ArrayList<Entreestock> rechercherEntreestock(Entreestock entreStoc)throws Exception
{
 conn=ConnectDb.getConnection();
  String query="select * from Entreestock where nomPro like  ? "
          + "or dateFabPro like ? or datePerPro like ? ";
ps=conn.prepareStatement(query);

     
    // ps.setString(1,"%"+ entreStoc.getNomPro()+"%");
    // ps.setString(2, "%"+entreStoc.getDateFabPro()+"%");
    // ps.setString(3,"%"+ entreStoc.getDatePerPro()+"%");
     
    // ps.setInt(3, entreStoc.getEtatstock_idstock());
     
     rs = ps.executeQuery();
     Entreestock entreStoc2 = new Entreestock();
   ArrayList<Entreestock> entreStoc1 = new ArrayList();
 //codePro	nomPro	dateFabPro	datePerPro	prixVentePro	codeFam
   while(rs.next())
   {
	// idEntree	prixAchat	qteEntree	codePro
    entreStoc2.setCodePro(rs.getInt("idEntree"));
      
    entreStoc2.setPrixAchat(rs.getInt("prixAchat"));
    entreStoc2.setQteEntree(rs.getInt("qteEntree"));
   
    entreStoc2.setCodePro(rs.getInt("codePro"));
    entreStoc1.add(entreStoc2);
   }
   conn.close();
   
   return entreStoc1;
}
public static void supprimerEntreestock(Entreestock entreStoc)throws Exception
{
   String query="delete from Entreestock   where idEntree= ?";
           
  conn=ConnectDb.getConnection();
   ps=conn.prepareStatement(query);
   ps.setInt(1, entreStoc.getCodePro());
   ps.executeUpdate();
   conn.close();
} 
///-------------------tableActualiSoc Entreestock-------------------------------------------------




public static void tableActualiSoc(Entreestock entreStoc)throws Exception
 {
     try
     {
      conn=ConnectDb.getConnection();
      String query="select*from Entreestock ";
      ps=conn.prepareStatement(query);
      rs=ps.executeQuery();
      ResultSetMetaData rsmd=rs.getMetaData();
      int c=rsmd.getColumnCount();
      while(rs.next())
      {
    	  entreStoc.getIdEntree();
          entreStoc.getPrixAchat();
          entreStoc.getQteEntree();
          entreStoc.getCodePro();
         
      }
     }
     catch(SQLException e)
     {
         e.printStackTrace();
     }
 }

//=============================== stock sortie  ================================	



public static ArrayList<Sortiestock> getSortiestock()throws Exception
{
   ArrayList<Sortiestock> stocSor1 = new ArrayList();
   try
   {
    conn=ConnectDb.getConnection();
    String query="select*from Sortiestock ";
    st = conn.createStatement();
    rs=st.executeQuery(query);
    Sortiestock stocSor= null;
    
    while(rs.next())
    {
  	  
  	  //idSortie	numFacture	nomClient	dateSortie	qteSortie	codePro
   	 stocSor = new Sortiestock();
   	stocSor.setIdSortie(rs.getInt("idSortie"));
   	stocSor.setNumFacture(rs.getInt("numFacture"));
         
         stocSor.setNomClient(rs.getString("nomClient"));
         
         stocSor.setDateSortie(rs.getString("dateSortie"));
         stocSor.setQteSortie(rs.getInt("qteSortie"));
         
         stocSor.setCodePro(rs.getInt("codePro"));
    
    

         
         stocSor1.add(stocSor);
				
			
     //     sc.getNomSortiestock();
   
    }
   }
   catch(SQLException e)
   {
       e.printStackTrace();
   }
   return stocSor1;
   
}

public static void inSertSortiestock (Sortiestock stocSor) throws Exception
{
 String query="insert into Sortiestock (idSortie,numFacture,nomClient,dateSortie,qteSortie,codePro) values (?,?,?,?,?,?)";
conn=ConnectDb.getConnection();
 ps=conn.prepareStatement(query);
 
 int idsortie = stocSor.getIdSortie();
 int numFacture = stocSor.getNumFacture();
 String nomClient = stocSor.getNomClient();
 String dateSortie = stocSor.getDateSortie();
 
 int qteSortie = stocSor.getQteSortie();
 int codePro = stocSor.getCodePro();
 


 ps.setInt(1, idsortie);
 ps.setInt(2, numFacture);
 ps.setString(3, nomClient);
 ps.setString(4, dateSortie);
 ps.setInt(3, qteSortie);
 ps.setInt(4, codePro);

 
 
  
 ps.executeUpdate();
 conn.close();
}
public static void modifierSortiestock(Sortiestock stocSor)throws Exception
{
	
 String query="update Sortiestock set numFacture=?,"
         + "nomClient=?,dateSortie=?,qteSortie=?,codePro=? "
         + "where codePro = ?";
         
 
//idSortie	numFacture	nomClient	dateSortie	qteSortie	codePro
conn=ConnectDb.getConnection();
 ps=conn.prepareStatement(query);
 //ps.setInt(, stocSor.getCodePro());
 
 ps.setInt(1, stocSor.getIdSortie());
 ps.setInt(2, stocSor.getNumFacture());
 ps.setString(3, stocSor.getNomClient()); 
 ps.setString(4, stocSor.getDateSortie()); 
 
 ps.setInt(3, stocSor.getQteSortie()); 
 ps.setInt(4, stocSor.getCodePro()); 

 
 ps.executeUpdate();
 conn.close();

}
public static ArrayList<Sortiestock> rechercherSortiestock(Sortiestock stocSor)throws Exception
{
conn=ConnectDb.getConnection();
String query="select * from Sortiestock where nomPro like  ? "
        + "or dateFabPro like ? or datePerPro like ? ";
ps=conn.prepareStatement(query);

   
  // ps.setString(1,"%"+ stocSor.getNomPro()+"%");
  // ps.setString(2, "%"+stocSor.getDateFabPro()+"%");
  // ps.setString(3,"%"+ stocSor.getDatePerPro()+"%");
   
  // ps.setInt(3, stocSor.getEtatstock_idstock());
   
   rs = ps.executeQuery();
   Sortiestock stocSor2 = new Sortiestock();
 ArrayList<Sortiestock> stocSor1 = new ArrayList();
//codePro	nomPro	dateFabPro	datePerPro	prixVentePro	codeFam
 while(rs.next())
 {
	// idSortie	numFacture	nomClient	dateSortie	qteSortie	codePro
  stocSor2.setCodePro(rs.getInt("idSortie"));
    
  stocSor2.setNumFacture(rs.getInt("numFacture"));
  stocSor2.setNomClient(rs.getString("nomClient"));
  stocSor2.setDateSortie(rs.getString("dateSortie"));
  stocSor2.setQteSortie(rs.getInt("qteSortie"));
 
  stocSor2.setCodePro(rs.getInt("codePro"));
  stocSor1.add(stocSor2);
 }
 conn.close();
 
 return stocSor1;
}
public static void supprimerSortiestock(Sortiestock stocSor)throws Exception
{
 String query="delete from Sortiestock   where idSortie= ?";
         
conn=ConnectDb.getConnection();
 ps=conn.prepareStatement(query);
 ps.setInt(1, stocSor.getCodePro());
 ps.executeUpdate();
 conn.close();
} 
///-------------------tableActualiSoc Sortiestock-------------------------------------------------




public static void tableActualiSoc(Sortiestock stocSor)throws Exception
{
   try
   {
    conn=ConnectDb.getConnection();
    String query="select*from Sortiestock ";
    ps=conn.prepareStatement(query);
    rs=ps.executeQuery();
    ResultSetMetaData rsmd=rs.getMetaData();
    int c=rsmd.getColumnCount();
    while(rs.next())
    {
  	  stocSor.getIdSortie();
        stocSor.getNumFacture();
        stocSor.getNomClient();
        stocSor.getDateSortie();
        stocSor.getQteSortie();
        stocSor.getCodePro();
        
        //idSortie	numFacture	nomClient	dateSortie	qteSortie	codePro
       
    }
   }
   catch(SQLException e)
   {
       e.printStackTrace();
   }
}

//=============================== Vendre  ================================	



public static ArrayList<Vendre> getVendre()throws Exception
{
 ArrayList<Vendre> vend1 = new ArrayList();
 try
 {
  conn=ConnectDb.getConnection();
  String query="select*from Vendre ";
  st = conn.createStatement();
  rs=st.executeQuery(query);
  Vendre vend= null;
  
  while(rs.next())
  {
	  
	  //idSortie	idUti
 	 vend = new Vendre();
 	vend.setIdSortie(rs.getInt("idSortie"));
 	vend.setIdUti(rs.getInt("idUti"));
       
  
  

       
       vend1.add(vend);
				
			
   //     sc.getNomVendre();
 
  }
 }
 catch(SQLException e)
 {
     e.printStackTrace();
 }
 return vend1;
 
}

public static void inSertVendre(Vendre vend) throws Exception
{
String query="insert into Vendre (nomprod_Produit,adresprod_Produit,	persContact_Produit,tauxPriseprod_Produit) values (?,?,?,?)";
conn=ConnectDb.getConnection();
ps=conn.prepareStatement(query);
//idSortie	idUti
int idsortie = vend.getIdSortie();
int idUti = vend.getIdUti();



ps.setInt(1, idsortie);
ps.setInt(2, idUti);





ps.executeUpdate();
conn.close();
}
public static void modifierVendre(Vendre vend)throws Exception
{
	
String query="update vendre set idUti=?,"
       + "where idSortie = ?";
       

//idSortie	idUti
conn=ConnectDb.getConnection();
ps=conn.prepareStatement(query);

ps.setInt(1, vend.getIdUti());
ps.setInt(2, vend.getIdSortie());

ps.executeUpdate();
conn.close();

}
public static ArrayList<Vendre> rechercherVendre(Vendre vend)throws Exception
{
conn=ConnectDb.getConnection();
String query="select * from vendre where 	idUti like  ? "
      + "or idSortie like ? ";
ps=conn.prepareStatement(query);

 
 ps.setString(1,"%"+ vend.getIdUti()+"%");
 ps.setString(2, "%"+vend.getIdSortie()+"%");

 
 rs = ps.executeQuery();
 Vendre vend2 = new Vendre();
ArrayList<Vendre> vend1 = new ArrayList();
//idSortie	idUti
while(rs.next())
{
	//idSortie	idUti
vend2.setIdSortie(rs.getInt("idSortie"));
  
vend2.setIdUti(rs.getInt("idUti"));

vend1.add(vend2);
}
conn.close();

return vend1;
}
public static void supprimerVendre(Vendre vend)throws Exception
{
String query="delete from Vendre   where idSortie= ?";
//idSortie	idUti  
conn=ConnectDb.getConnection();
ps=conn.prepareStatement(query);
ps.setInt(1, vend.getIdSortie());
ps.executeUpdate();
conn.close();
} 
///-------------------tableActualiSoc Vendre-------------------------------------------------




public static void tableActualiSoc(Vendre vend)throws Exception
{
 try
 {
  conn=ConnectDb.getConnection();
  String query="select*from Vendre ";
  ps=conn.prepareStatement(query);
  rs=ps.executeQuery();
  ResultSetMetaData rsmd=rs.getMetaData();
  int c=rsmd.getColumnCount();
  while(rs.next())
  {
	  vend.getIdSortie();
      vend.getIdUti();
      
      
    //idSortie	idUti  
     
  }
 }
 catch(SQLException e)
 {
     e.printStackTrace();
 }
}

//=============================== Saisir  ================================	



public static ArrayList<Saisir> getSaisir()throws Exception
{
ArrayList<Saisir> saiz1 = new ArrayList();
try
{
conn=ConnectDb.getConnection();
String query="select*from Saisir ";
st = conn.createStatement();
rs=st.executeQuery(query);
Saisir saiz= null;

while(rs.next())
{
	  
	  //idUti	idEntree
	 saiz = new Saisir();
	saiz.setIdEntree(rs.getInt("idEntree"));
	saiz.setIdUti(rs.getInt("idUti"));
     



     
     saiz1.add(saiz);
				
			
 //     sc.getNomSaisir();

}
}
catch(SQLException e)
{
   e.printStackTrace();
}
return saiz1;

}

public static void inSertSaisir(Saisir saiz) throws Exception
{
String query="insert into Saisir (nomprod_Produit,adresprod_Produit,	persContact_Produit,tauxPriseprod_Produit) values (?,?,?,?)";
conn=ConnectDb.getConnection();
ps=conn.prepareStatement(query);
//idUti	idEntree
int idEntree = saiz.getIdEntree();
int idUti = saiz.getIdUti();



ps.setInt(1, idEntree);
ps.setInt(2, idUti);





ps.executeUpdate();
conn.close();
}
public static void modifierSaisir(Saisir saiz)throws Exception
{
	
String query="update saisir set idUti=?,"
     + "where idEntree = ?";
     

//idUti	idEntree
conn=ConnectDb.getConnection();
ps=conn.prepareStatement(query);

ps.setInt(1, saiz.getIdUti());
ps.setInt(2, saiz.getIdEntree());

ps.executeUpdate();
conn.close();

}
public static ArrayList<Saisir> rechercherSaisir(Saisir saiz)throws Exception
{
conn=ConnectDb.getConnection();
String query="select * from saisir where 	idUti like  ? "
    + "or idEntree like ? ";
ps=conn.prepareStatement(query);

//idUti	idEntree
ps.setString(1,"%"+ saiz.getIdUti()+"%");
ps.setString(2, "%"+saiz.getIdEntree()+"%");


rs = ps.executeQuery();
Saisir saiz2 = new Saisir();
ArrayList<Saisir> saiz1 = new ArrayList();
//idUti	idEntree
while(rs.next())
{
	//idUti	idEntree
saiz2.setIdEntree(rs.getInt("idEntree"));

saiz2.setIdUti(rs.getInt("idUti"));

saiz1.add(saiz2);
}
conn.close();

return saiz1;
}
public static void supprimerSaisir(Saisir saiz)throws Exception
{
String query="delete from Saisir   where idSortie= ?";
//idSortie	idUti  
conn=ConnectDb.getConnection();
ps=conn.prepareStatement(query);
ps.setInt(1, saiz.getIdEntree());
ps.executeUpdate();
conn.close();
} 
///-------------------tableActualiSoc Saisir-------------------------------------------------




public static void tableActualiSoc(Saisir saiz)throws Exception
{
try
{
conn=ConnectDb.getConnection();
String query="select*from Saisir ";
ps=conn.prepareStatement(query);
rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();
int c=rsmd.getColumnCount();
while(rs.next())
{
	  saiz.getIdEntree();
    saiz.getIdUti();
    
    
  //idSortie	idUti  
   
}
}
catch(SQLException e)
{
   e.printStackTrace();
}
}


//=============================== Famille Produit  ================================	



public static ArrayList<Familllepro> getFamilllepro()throws Exception
{
ArrayList<Familllepro> famPro1 = new ArrayList();
try
{
conn=ConnectDb.getConnection();
String query="select*from famillepro ";
st = conn.createStatement();
rs=st.executeQuery(query);
Familllepro famPro= null;

while(rs.next())
{
	  
	  //codeFam	nomFam
	 famPro = new Familllepro();
	famPro.setCodeFam(rs.getInt("codeFam"));
	famPro.setNomFam(rs.getString("nomFam"));
   



   
   famPro1.add(famPro);
				
			
//     sc.getNomFamilllepro();

}
}
catch(SQLException e)
{
 e.printStackTrace();
}
return famPro1;

}

public static void inSertFamilllepro(Familllepro famPro) throws Exception
{
String query="insert into famillepro (nomFam) values (?)";
conn=ConnectDb.getConnection();
ps=conn.prepareStatement(query);
//codeFam	nomFam
int codefam = famPro.getCodeFam();
String nomFam = famPro.getNomFam();



//ps.setInt(1, codefam);
ps.setString(1, nomFam);





ps.executeUpdate();
conn.close();
}
public static void modifierFamilllepro(Familllepro famPro)throws Exception
{
	
String query="update famillepro set nomFam=?,"
   + "where codeFam = ?";
   

////codeFam	nomFam
conn=ConnectDb.getConnection();
ps=conn.prepareStatement(query);

ps.setString(1, famPro.getNomFam());
ps.setInt(2, famPro.getCodeFam());

ps.executeUpdate();
conn.close();

}
public static ArrayList<Familllepro> rechercherFamilllepro(Familllepro famPro)throws Exception
{
conn=ConnectDb.getConnection();
String query="select * from famillepro where 	codeFam like  ? "
  + "or nomFam like ? ";
ps=conn.prepareStatement(query);

////codeFam	nomFam
ps.setString(1,"%"+ famPro.getCodeFam()+"%");
ps.setString(2, "%"+famPro.getNomFam()+"%");


rs = ps.executeQuery();
Familllepro famPro2 = new Familllepro();
ArrayList<Familllepro> famPro1 = new ArrayList();
//idUti	idEntree
while(rs.next())
{
////codeFam	nomFam
famPro2.setCodeFam(rs.getInt("codeFam"));

famPro2.setNomFam(rs.getString("nomFam"));

famPro1.add(famPro2);
}
conn.close();

return famPro1;
}
public static void supprimerFamilllepro(Familllepro famPro)throws Exception
{
String query="delete from famillepro   where codeFam= ?";
////codeFam	nomFam
conn=ConnectDb.getConnection();
ps=conn.prepareStatement(query);
ps.setInt(1, famPro.getCodeFam());
ps.executeUpdate();
conn.close();
} 
///-------------------tableActualiSoc Familllepro-------------------------------------------------




public static void tableActualiSoc(Familllepro famPro)throws Exception
{
try
{
conn=ConnectDb.getConnection();
String query="select*from Familllepro ";
ps=conn.prepareStatement(query);
rs=ps.executeQuery();
ResultSetMetaData rsmd=rs.getMetaData();
int c=rsmd.getColumnCount();
while(rs.next())
{
	  famPro.getCodeFam();
  famPro.getNomFam();
  
  
////codeFam	nomFam  
 
}
}
catch(SQLException e)
{
 e.printStackTrace();
}
}

//=============================== entrer Etatstock  ================================	



public static ArrayList<Etatstock> getEtatstock()throws Exception
{
   ArrayList<Etatstock> etat1 = new ArrayList();
   try
   {
    conn=ConnectDb.getConnection();
    String query="select*from Etatstock ";
    st = conn.createStatement();
    rs=st.executeQuery(query);
    Etatstock etat= null;
    
    while(rs.next())
    {
  	  
  	  //idStock	qteStock	seuilStock	sortiestock_idsortie_sortiestock	entreestock_identree_entreestock	utilisateur_iduti_utilisateur	codePro
   	 etat = new Etatstock();
   	etat.setIdStock(rs.getInt("idStock"));
   	etat.setQteStock(rs.getInt("qteStock"));
         
     etat.setSeuilStock(rs.getString("seuilStock"));
         
     etat.setSortiestock_idsortie_sortiestock(rs.getInt("sortiestock_idsortie_sortiestock"));
         
     etat.setEntreestock_identree_entreestock(rs.getInt("entreestock_identree_entreestock"));
	etat.setUtilisateur_iduti_utilisateur(rs.getInt("utilisateur_iduti_utilisateur"));
       
    

         
         etat1.add(etat);
				
			
     //     sc.getNomEtatstock();
   
    }
   }
   catch(SQLException e)
   {
       e.printStackTrace();
   }
   return etat1;
   
}

}


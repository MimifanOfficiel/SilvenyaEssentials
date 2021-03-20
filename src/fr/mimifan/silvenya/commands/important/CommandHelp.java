package fr.mimifan.silvenya.commands.important;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import fr.mimifan.silvenya.Main;

@SuppressWarnings("deprecation")
public class CommandHelp implements CommandExecutor, Listener {

	private Main main;
	
	public CommandHelp(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player)sender;
		List<String> l = new ArrayList<>();
		
		//Menus
		Inventory help = Bukkit.createInventory(null, 9, main.getConfig().getString("help.gui.main.title").replace("&", "§").replace(">", "»"));
		Inventory commands = Bukkit.createInventory(null, 27, main.getConfig().getString("help.gui.commands.title").replace("&", "§").replace(">", "»"));
		Inventory shop = Bukkit.createInventory(null, 9, main.getConfig().getString("help.gui.shop.title").replace("&", "§").replace(">", "»"));
		Inventory economie = Bukkit.createInventory(null, 9, main.getConfig().getString("help.gui.economie.title").replace("&", "§").replace(">", "»"));
		Inventory grades = Bukkit.createInventory(null, 18, main.getConfig().getString("help.gui.grades.title").replace("&", "§").replace(">", "»"));
		Inventory staffs = Bukkit.createInventory(null, 9, main.getConfig().getString("help.gui.staffs.title").replace("&", "§").replace(">", "»"));
		Inventory liststaff = Bukkit.createInventory(null, 9, main.getConfig().getString("help.gui.liststaff.title").replace("&", "§").replace(">", "»"));
		Inventory tp = Bukkit.createInventory(null, 27, main.getConfig().getString("help.gui.tp.title").replace("&", "§").replace(">", "»"));
		Inventory reseaux = Bukkit.createInventory(null, 9, main.getConfig().getString("help.gui.reseaux.title").replace("&", "§").replace(">", "»"));
		
		//Items
		ItemStack retour = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.items_multi.retour.item")));
		ItemStack glass = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.items_multi.glass.item")));
		
		ItemStack menu_shop = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.main.items.menu_shop.item")));
		ItemStack menu_commands = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.main.items.menu_commands.item")));
		ItemStack menu_staff = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.main.items.menu_staff.item")));
		ItemStack menu_eco = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.main.items.menu_eco.item")));
		
		ItemStack téléportations = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.commands.items.téléportations.item")));
		ItemStack menu_reseaux = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.commands.items.menu_reseaux.item")));
		
		ItemStack rtp = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.tp.items.randomtp.item")));
		ItemStack tpa = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.tp.items.tpa.item")));
		ItemStack tpahere = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.tp.items.tpahere.item")));
		ItemStack tpaall = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.tp.items.tpaall.item")));
		ItemStack tpall = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.tp.items.tpall.item")));
		ItemStack tpyes = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.tp.items.tpyes.item")));
		ItemStack tpcmd = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.tp.items.tp.item")));
		ItemStack tppos = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.tp.items.tppos.item")));
		
		ItemStack menu_grades = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.shop.items.grades.item")));
		ItemStack boutique = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.shop.items.boutique.item")));
		
		ItemStack paysan = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.grades.items.paysan.item")));
		ItemStack fermier = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.grades.items.fermier.item")));
		ItemStack seigneur = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.grades.items.seigneur.item")));
		
		ItemStack lstaff = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.staffs.items.staff.item")));
		ItemStack cmt = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.staffs.items.cmt.item")));
		
		ItemStack mimifan = new ItemStack(Material.PLAYER_HEAD);
		ItemStack gigi = new ItemStack(Material.PLAYER_HEAD);
		ItemStack natsou = new ItemStack(Material.PLAYER_HEAD);
		ItemStack light = new ItemStack(Material.PLAYER_HEAD);
		ItemStack zzeph = new ItemStack(Material.PLAYER_HEAD);
		ItemStack kinder = new ItemStack(Material.PLAYER_HEAD);
		
		ItemStack quelle_eco = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.economie.items.laquelle.item")));
		ItemStack cmt_get = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.economie.items.cmt_get.item")));
		
		ItemStack discord = new ItemStack(Material.matchMaterial(main.getConfig().getString("help.gui.reseaux.items.discord.item")));
		
		//ItemMetas
		ItemMeta retourM = retour.getItemMeta();
		ItemMeta glassM = glass.getItemMeta();
		
		ItemMeta menu_shopM = menu_shop.getItemMeta();
		ItemMeta menu_commandsM = menu_commands.getItemMeta();
		ItemMeta téléportationsM = téléportations.getItemMeta();
		ItemMeta menu_reseauxM = menu_reseaux.getItemMeta();
		ItemMeta menu_gradesM = menu_grades.getItemMeta();
		ItemMeta menu_staffM = menu_staff.getItemMeta();
		ItemMeta menu_ecoM = menu_eco.getItemMeta();
		
		ItemMeta boutiqueM = boutique.getItemMeta();
		
		ItemMeta paysanM = paysan.getItemMeta();
		ItemMeta fermierM = fermier.getItemMeta();
		ItemMeta seigneurM = seigneur.getItemMeta();
		
		ItemMeta lstaffM = lstaff.getItemMeta();
		ItemMeta cmtM = cmt.getItemMeta();
		
		ItemMeta staffM = lstaff.getItemMeta();
		SkullMeta mimifanM = (SkullMeta) mimifan.getItemMeta();
		SkullMeta gigiM = (SkullMeta) gigi.getItemMeta();
		SkullMeta natsouM = (SkullMeta) natsou.getItemMeta();
		SkullMeta lightM = (SkullMeta) light.getItemMeta();
		SkullMeta zzephM = (SkullMeta) zzeph.getItemMeta();
		SkullMeta kinderM = (SkullMeta) kinder.getItemMeta();
		
		ItemMeta quelle_ecoM = quelle_eco.getItemMeta();
		ItemMeta cmt_getM = cmt_get.getItemMeta();
		
		ItemMeta rtpM = rtp.getItemMeta();
		ItemMeta tpaM = tpa.getItemMeta();
		ItemMeta tpahereM = tpahere.getItemMeta();
		ItemMeta tpaallM = tpaall.getItemMeta();
		ItemMeta tpallM = tpall.getItemMeta();
		ItemMeta tpyesM = tpyes.getItemMeta();
		ItemMeta tpcmdM = tpcmd.getItemMeta();
		ItemMeta tpposM = tppos.getItemMeta();
		
		ItemMeta discordM = discord.getItemMeta();
		
		
		//SetName
		retourM.setDisplayName(main.getConfig().getString("help.items_multi.retour.item_name").replace("&", "§"));
		glassM.setDisplayName(main.getConfig().getString("help.items_multi.glass.item_name").replace("&", "§"));
		
		menu_shopM.setDisplayName(main.getConfig().getString("help.gui.main.items.menu_shop.item_name").replace("&", "§"));
		menu_commandsM.setDisplayName(main.getConfig().getString("help.gui.main.items.menu_commands.item_name").replace("&", "§"));
		menu_staffM.setDisplayName(main.getConfig().getString("help.gui.main.items.menu_staff.item_name").replace("&", "§"));
		menu_ecoM.setDisplayName(main.getConfig().getString("help.gui.main.items.menu_eco.item_name").replace("&", "§"));
		
		téléportationsM.setDisplayName(main.getConfig().getString("help.gui.commands.items.téléportations.item_name").replace("&", "§"));
		menu_reseauxM.setDisplayName(main.getConfig().getString("help.gui.commands.items.menu_reseaux.item_name").replace("&", "§"));
		
		menu_gradesM.setDisplayName(main.getConfig().getString("help.gui.shop.items.grades.item_name").replace("&", "§"));
		boutiqueM.setDisplayName(main.getConfig().getString("help.gui.shop.items.boutique.item_name").replace("&", "§"));
		
		paysanM.setDisplayName(main.getConfig().getString("help.gui.grades.items.paysan.item_name").replace("&", "§"));
		fermierM.setDisplayName(main.getConfig().getString("help.gui.grades.items.fermier.item_name").replace("&", "§"));
		seigneurM.setDisplayName(main.getConfig().getString("help.gui.grades.items.seigneur.item_name").replace("&", "§"));
		
		lstaffM.setDisplayName(main.getConfig().getString("help.gui.staffs.items.staff.item_name").replace("&", "§"));
		cmtM.setDisplayName(main.getConfig().getString("help.gui.staffs.items.cmt.item_name").replace("&", "§"));
		
		staffM.setDisplayName(main.getConfig().getString("help.gui.main.items.liststaff.itemname"));
		mimifanM.setDisplayName(main.getConfig().getString("help.gui.liststaff.items.mimifan.item_name").replace("&", "§"));
		gigiM.setDisplayName(main.getConfig().getString("help.gui.liststaff.items.__Ginette__.item_name").replace("&", "§"));
		natsouM.setDisplayName(main.getConfig().getString("help.gui.liststaff.items.Natsou.item_name").replace("&", "§"));
		lightM.setDisplayName(main.getConfig().getString("help.gui.liststaff.items._Alexiis_.item_name").replace("&", "§"));
		zzephM.setDisplayName(main.getConfig().getString("help.gui.liststaff.items.Zzephwir.item_name").replace("&", "§"));
		kinderM.setDisplayName(main.getConfig().getString("help.gui.liststaff.items.BaronKinder.item_name").replace("&", "§"));

		quelle_ecoM.setDisplayName(main.getConfig().getString("help.gui.economie.items.laquelle.item_name").replace("&", "§"));
		cmt_getM.setDisplayName(main.getConfig().getString("help.gui.economie.items.cmt_get.item_name").replace("&", "§"));
		
		rtpM.setDisplayName(main.getConfig().getString("help.gui.tp.items.randomtp.item_name").replace("&", "§"));
		tpaM.setDisplayName(main.getConfig().getString("help.gui.tp.items.tpa.item_name").replace("&", "§"));
		tpahereM.setDisplayName(main.getConfig().getString("help.gui.tp.items.tpahere.item_name").replace("&", "§"));
		tpaallM.setDisplayName(main.getConfig().getString("help.gui.tp.items.tpaall.item_name").replace("&", "§"));
		tpallM.setDisplayName(main.getConfig().getString("help.gui.tp.items.tpall.item_name").replace("&", "§"));
		tpyesM.setDisplayName(main.getConfig().getString("help.gui.tp.items.tpyes.item_name").replace("&", "§"));
		tpcmdM.setDisplayName(main.getConfig().getString("help.gui.tp.items.tp.item_name").replace("&", "§"));
		tpposM.setDisplayName(main.getConfig().getString("help.gui.tp.items.tppos.item_name").replace("&", "§"));
		
		discordM.setDisplayName(main.getConfig().getString("help.gui.reseaux.items.discord.item_name").replace("&", "§"));
		
		//SetLore
		l.add(main.getConfig().getString("help.items_multi.retour.item_lore").replace("&", "§"));
		retourM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.items_multi.glass.item_lore").replace("&", "§"));
		glassM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.main.items.menu_shop.item_lore").replace("&", "§"));
		menu_shopM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.main.items.menu_staff.item_lore").replace("&", "§"));
		menu_staffM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.main.items.menu_commands.item_lore").replace("&", "§"));
		menu_commandsM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.main.items.menu_eco.item_lore").replace("&", "§"));
		menu_ecoM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.economie.items.laquelle.item_lore").replace("&", "§"));
		quelle_ecoM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.economie.items.cmt_get.item_lore").replace("&", "§"));
		cmt_getM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.commands.items.téléportations.item_lore").replace("&", "§"));
		téléportationsM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.shop.items.boutique.item_lore").replace("&", "§"));
		boutiqueM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.grades.items.paysan.item_lore.1").replace("&", "§"));
		l.add(main.getConfig().getString("help.gui.grades.items.paysan.item_lore.2").replace("&", "§"));
		paysanM.setLore(l);
		l.clear();

		l.add(main.getConfig().getString("help.gui.grades.items.fermier.item_lore.1").replace("&", "§"));
		l.add(main.getConfig().getString("help.gui.grades.items.fermier.item_lore.2").replace("&", "§"));
		fermierM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.grades.items.seigneur.item_lore.1").replace("&", "§"));
		l.add(main.getConfig().getString("help.gui.grades.items.seigneur.item_lore.2").replace("&", "§"));
		seigneurM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.staffs.items.staff.item_lore").replace("&", "§"));
		lstaffM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.staffs.items.cmt.item_lore").replace("&", "§"));
		cmtM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.liststaff.items.mimifan.item_lore.1").replace("&", "§"));
		mimifanM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.liststaff.items.__Ginette__.item_lore.1").replace("&", "§"));
		gigiM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.liststaff.items.Natsou.item_lore.1").replace("&", "§"));
		natsouM.setLore(l);
		l.clear();

		l.add(main.getConfig().getString("help.gui.liststaff.items._Alexiis_.item_lore.1").replace("&", "§"));
		lightM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.liststaff.items.Zzephwir.item_lore.1").replace("&", "§"));
		zzephM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.liststaff.items.BaronKinder.item_lore.1").replace("&", "§"));
		kinderM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.tp.items.randomtp.item_lore.1").replace("&", "§"));
		l.add(main.getConfig().getString("help.gui.tp.items.randomtp.item_lore.2").replace("&", "§"));
		rtpM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.tp.items.tpa.item_lore").replace("&", "§"));
		tpaM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.tp.items.tpahere.item_lore").replace("&", "§"));
		tpahereM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.tp.items.tpaall.item_lore").replace("&", "§"));
		tpaallM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.tp.items.tpyes.item_lore.1").replace("&", "§"));
		l.add(main.getConfig().getString("help.gui.tp.items.tpyes.item_lore.2").replace("&", "§"));
		tpyesM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.tp.items.tp.item_lore").replace("&", "§"));
		tpcmdM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.tp.items.tpall.item_lore").replace("&", "§"));
		tpallM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.tp.items.tppos.item_lore").replace("&", "§"));
		tpposM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.commands.items.menu_reseaux.item_lore").replace("&", "§"));
		menu_reseauxM.setLore(l);
		l.clear();
		
		l.add(main.getConfig().getString("help.gui.reseaux.items.discord.item_lore.1").replace("&", "§"));
		l.add(main.getConfig().getString("help.gui.reseaux.items.discord.item_lore.2").replace("&", "§"));
		discordM.setLore(l);
		l.clear();
		
		
		//Head
		mimifanM.setOwningPlayer(Bukkit.getOfflinePlayer("Mimifan_"));
		gigiM.setOwningPlayer(Bukkit.getOfflinePlayer("__Ginette__"));
		natsouM.setOwningPlayer(Bukkit.getOfflinePlayer("Elvashak_"));
		lightM.setOwningPlayer(Bukkit.getOfflinePlayer("_Alexiis_"));
		zzephM.setOwningPlayer(Bukkit.getOfflinePlayer("Zzephwir"));
		kinderM.setOwningPlayer(Bukkit.getOfflinePlayer("BaronKinder"));
		
		
		//SetMeta
		retour.setItemMeta(retourM);
		glass.setItemMeta(glassM);
		
		menu_shop.setItemMeta(menu_shopM);
		menu_commands.setItemMeta(menu_commandsM);
		menu_staff.setItemMeta(menu_staffM);
		menu_eco.setItemMeta(menu_ecoM);
		
		quelle_eco.setItemMeta(quelle_ecoM);
		cmt_get.setItemMeta(cmt_getM);
		
		téléportations.setItemMeta(téléportationsM);
		menu_reseaux.setItemMeta(menu_reseauxM);
		
		menu_grades.setItemMeta(menu_gradesM);
		boutique.setItemMeta(boutiqueM);
		
		paysan.setItemMeta(paysanM);
		fermier.setItemMeta(fermierM);
		seigneur.setItemMeta(seigneurM);
		
		lstaff.setItemMeta(lstaffM);
		cmt.setItemMeta(cmtM);
		
		mimifan.setItemMeta(mimifanM);
		gigi.setItemMeta(gigiM);
		natsou.setItemMeta(natsouM);
		light.setItemMeta(lightM);
		zzeph.setItemMeta(zzephM);
		kinder.setItemMeta(kinderM);
		
		rtp.setItemMeta(rtpM);
		tpa.setItemMeta(tpaM);
		tpahere.setItemMeta(tpahereM);
		tpaall.setItemMeta(tpaallM);
		tpall.setItemMeta(tpallM);
		tpyes.setItemMeta(tpyesM);
		tpcmd.setItemMeta(tpcmdM);
		tppos.setItemMeta(tpposM);
		
		discord.setItemMeta(discordM);
		
		
		//SetItem
		commands.setItem(26, retour);
		shop.setItem(8, retour);
		grades.setItem(17, retour);
		staffs.setItem(8, retour);
		liststaff.setItem(8, retour);
		economie.setItem(8, retour);
		tp.setItem(26, retour);
		
		help.setItem(main.getConfig().getInt("help.gui.main.items.menu_shop.place"), menu_shop);
		help.setItem(main.getConfig().getInt("help.gui.main.items.menu_commands.place"), menu_commands);
		help.setItem(main.getConfig().getInt("help.gui.main.items.menu_staff.place"), menu_staff);
		help.setItem(main.getConfig().getInt("help.gui.main.items.menu_eco.place"), menu_eco);
		help.setItem(1, glass);
		help.setItem(3, glass);
		help.setItem(5, glass);
		help.setItem(7, glass);
		
		economie.setItem(main.getConfig().getInt("help.gui.economie.items.laquelle.place"), quelle_eco);
		economie.setItem(main.getConfig().getInt("help.gui.economie.items.cmt_get.place"), cmt_get);
		economie.setItem(1, glass);
		economie.setItem(2, glass);
		economie.setItem(3, glass);
		economie.setItem(5, glass);
		economie.setItem(6, glass);
		economie.setItem(7, glass);
		
		commands.setItem(main.getConfig().getInt("help.gui.main.items.téléportations.place"), téléportations);
		commands.setItem(main.getConfig().getInt("help.gui.main.items.menu_reseaux.place"), menu_reseaux);
		
		shop.setItem(main.getConfig().getInt("help.gui.shop.items.grades.place"), menu_grades);
		shop.setItem(main.getConfig().getInt("help.gui.shop.items.boutique.place"), boutique);
		shop.setItem(1, glass);
		shop.setItem(2, glass);
		shop.setItem(3, glass);
		shop.setItem(5, glass);
		shop.setItem(6, glass);
		shop.setItem(7, glass);
		
		grades.setItem(main.getConfig().getInt("help.gui.grades.items.paysan.place"), paysan);
		grades.setItem(main.getConfig().getInt("help.gui.grades.items.fermier.place"), fermier);
		grades.setItem(main.getConfig().getInt("help.gui.grades.items.seigneur.place"), seigneur);
		grades.setItem(0, glass);
		grades.setItem(1, glass);
		grades.setItem(3, glass);
		grades.setItem(4, glass);
		grades.setItem(5, glass);
		grades.setItem(7, glass);
		grades.setItem(8, glass);
		grades.setItem(10, glass);
		grades.setItem(11, glass);
		grades.setItem(12, glass);
		grades.setItem(13, glass);
		grades.setItem(14, glass);
		grades.setItem(15, glass);
		grades.setItem(16, glass);
		
		staffs.setItem(main.getConfig().getInt("help.gui.staffs.items.staff.place"), lstaff);
		staffs.setItem(main.getConfig().getInt("help.gui.staffs.items.cmt.place"), cmt);
		staffs.setItem(1, glass);
		staffs.setItem(2, glass);
		staffs.setItem(3, glass);
		staffs.setItem(5, glass);
		staffs.setItem(6, glass);
		staffs.setItem(7, glass);
		
		liststaff.setItem(main.getConfig().getInt("help.gui.liststaff.items.mimifan.place"), mimifan);
		liststaff.setItem(main.getConfig().getInt("help.gui.liststaff.items.__Ginette__.place"), gigi);
		liststaff.setItem(main.getConfig().getInt("help.gui.liststaff.items.Natsou.place"), natsou);
		liststaff.setItem(main.getConfig().getInt("help.gui.liststaff.items._Alexiis_.place"), light);
		liststaff.setItem(main.getConfig().getInt("help.gui.liststaff.items.Zzephwir.place"), zzeph);
		liststaff.setItem(main.getConfig().getInt("help.gui.liststaff.items.BaronKinder.place"), kinder);
		liststaff.setItem(6, glass);
		liststaff.setItem(7, glass);
		
		tp.setItem(main.getConfig().getInt("help.gui.tp.items.randomtp.place"), rtp);
		tp.setItem(main.getConfig().getInt("help.gui.tp.items.tpa.place"), tpa);
		tp.setItem(main.getConfig().getInt("help.gui.tp.items.tpahere.place"), tpahere);
		tp.setItem(main.getConfig().getInt("help.gui.tp.items.tpaall.place"), tpaall);
		tp.setItem(main.getConfig().getInt("help.gui.tp.items.tpall.place"), tpall);
		tp.setItem(main.getConfig().getInt("help.gui.tp.items.tpyes.place"), tpyes);
		tp.setItem(main.getConfig().getInt("help.gui.tp.items.tp.place"), tpcmd);
		tp.setItem(main.getConfig().getInt("help.gui.tp.items.tppos.place"), tppos);
		tp.setItem(1, glass);
		tp.setItem(2, glass);
		tp.setItem(4, glass);
		tp.setItem(5, glass);
		tp.setItem(7, glass);
		tp.setItem(8, glass);
		tp.setItem(9, glass);
		tp.setItem(10, glass);
		tp.setItem(12, glass);
		tp.setItem(14, glass);
		tp.setItem(15, glass);
		tp.setItem(16, glass);
		tp.setItem(17, glass);
		tp.setItem(19, glass);
		tp.setItem(20, glass);
		tp.setItem(22, glass);
		tp.setItem(23, glass);
		tp.setItem(25, glass);
		
		reseaux.setItem(main.getConfig().getInt("help.gui.reseaux.items.discord.place"), discord);
		
		
		//OpenInv
		if(args.length == 0) {
			//player.openInventory(help);
			player.sendMessage(main.getConfig().getString("prefixs.all").replace("&", "§").replace(">", "»") + "Le /help n'est pas encore disponible, il le sera bientôt !");
			player.sendMessage(main.getConfig().getString("prefixs.all").replace("&", "§").replace(">", "»") + "En attendant, vous pouvez demander de l'aide aux membres du staff.");
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("cmds")) {
				//player.openInventory(commands);
			}
			if(args[0].equalsIgnoreCase("shop")) {
				//player.openInventory(shop);
			}
			if(args[0].equalsIgnoreCase("grades")) {
				//player.openInventory(grades);
			}
			if(args[0].equalsIgnoreCase("staff")) {
				//player.openInventory(staffs);
			}
			if(args[0].equalsIgnoreCase("liststaff")) {
				//player.openInventory(liststaff);
			}
			if(args[0].equalsIgnoreCase("economie")) {
				//player.openInventory(economie);
			}
			if(args[0].equalsIgnoreCase("tp")) {
				//player.openInventory(tp);
			}
			if(args[0].equalsIgnoreCase("reseaux")) {
				//player.openInventory(reseaux);
			}
		}
		
		return false;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getClickedInventory();
		int clickedSlot = event.getSlot();
		ItemStack itemStack = inventory.getItem(clickedSlot);
		if(itemStack.hasItemMeta()) {
			if(event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("help.gui.main.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.main.items.menu_commands.item_name").replace("&", "§"))) {
					player.performCommand("help cmds");
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.main.items.menu_shop.item_name").replace("&", "§"))) {
					player.performCommand("help shop");
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.main.items.menu_staff.item_name").replace("&", "§"))) {
					player.performCommand("help staff");
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.main.items.menu_eco.item_name").replace("&", "§"))) {
					player.performCommand("help economie");
				}
				if(itemStack.getType() == Material.BLACK_STAINED_GLASS_PANE) {
					event.setCancelled(true);
				}
			}
			if(event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("help.gui.commands.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.items_multi.retour.item_name").replace("&", "§"))) {
					player.performCommand("help");
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.commands.items.téléportations.item_name").replace("&", "§"))) {
					player.performCommand("help tp");
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.commands.items.menu_reseaux.item_name").replace("&", "§"))) {
					player.performCommand("help reseaux");
				}
			}
			if(event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("help.gui.economie.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.items_multi.retour.item_name").replace("&", "§"))) {
					player.performCommand("help");
				}
			}
			if(event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("help.gui.staffs.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.items_multi.retour.item_name").replace("&", "§"))) {
					player.performCommand("help");
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.staffs.items.staff.item_name").replace("&", "§"))) {
					player.performCommand("help liststaff");
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.staffs.items.cmt.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.staffs.items.cmt.comment.1").replace("&", "§").replace(">", "»"));
					player.sendMessage(main.getConfig().getString("help.gui.staffs.items.cmt.comment.2").replace("&", "§").replace(">", "»"));
					player.sendMessage(main.getConfig().getString("help.gui.staffs.items.cmt.comment.3").replace("&", "§").replace(">", "»"));
					player.sendMessage(main.getConfig().getString("help.gui.staffs.items.cmt.comment.4").replace("&", "§").replace(">", "»"));
					player.sendMessage(main.getConfig().getString("help.gui.staffs.items.cmt.comment.5").replace("&", "§").replace(">", "»"));
					player.closeInventory();
				}
				if(itemStack.getType() == Material.BLACK_STAINED_GLASS_PANE) {
					event.setCancelled(true);
				}
			}
			if(event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("help.gui.liststaff.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.items_multi.retour.item_name").replace("&", "§"))) {
					player.performCommand("help staff");
				}
			}
			if(event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("help.gui.shop.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.items_multi.retour.item_name").replace("&", "§"))) {
					player.performCommand("help");
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.shop.items.boutique.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.shop.items.boutique.msg").replace("&", "§").replace(">", "»"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.shop.items.grades.item_name").replace("&", "§"))) {
					player.performCommand("help grades");
				}
				if(itemStack.getType() == Material.BLACK_STAINED_GLASS_PANE) {
					event.setCancelled(true);
				}
			}
			if(event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("help.gui.grades.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.items_multi.retour.item_name").replace("&", "§"))) {
					player.performCommand("help shop");
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.grades.items.paysan.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.paysan.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.paysan.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.paysan.infos.3").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.paysan.infos.4").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.paysan.infos.5").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.grades.items.fermier.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.fermier.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.fermier.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.fermier.infos.3").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.fermier.infos.4").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.fermier.infos.5").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.fermier.infos.6").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.grades.items.seigneur.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.seigneur.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.seigneur.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.seigneur.infos.3").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.seigneur.infos.4").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.seigneur.infos.5").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.grades.items.seigneur.infos.6").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getType() == Material.BLACK_STAINED_GLASS_PANE) {
					event.setCancelled(true);
				}
			}
			if(event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("help.gui.liststaff.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.liststaff.items.mimifan.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.mimifan.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.mimifan.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.mimifan.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.liststaff.items.__Ginette__.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.__Ginette__.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.__Ginette__.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.__Ginette__.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.liststaff.items.Natsou.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.Natsou.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.Natsou.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.Natsou.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.liststaff.items._Alexiis_.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items._Alexiis_.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items._Alexiis_.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items._Alexiis_.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.liststaff.items.Zzephwir.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.Zzephwir.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.Zzephwir.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.Zzephwir.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.liststaff.items.BaronKinder.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.BaronKinder.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.BaronKinder.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.liststaff.items.BaronKinder.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getType() == Material.BLACK_STAINED_GLASS_PANE) {
					event.setCancelled(true);
				}
			}
			
			if(event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("help.gui.economie.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.economie.items.laquelle.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.economie.items.laquelle.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.economie.items.laquelle.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.economie.items.laquelle.infos.3").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.economie.items.laquelle.infos.4").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.economie.items.cmt_get.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.economie.items.cmt_get.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.economie.items.cmt_get.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.economie.items.cmt_get.infos.3").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.economie.items.cmt_get.infos.4").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getType() == Material.BLACK_STAINED_GLASS_PANE) {
					event.setCancelled(true);
				}
			}
			if(event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("help.gui.tp.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.tp.items.randomtp.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.randomtp.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.randomtp.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.randomtp.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.tp.items.tpa.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpa.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpa.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpa.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.tp.items.tpahere.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpahere.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpahere.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpahere.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.tp.items.tpaall.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpaall.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpaall.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpaall.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.tp.items.tpyes.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpyes.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpyes.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpyes.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.tp.items.tp.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tp.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tp.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tp.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.tp.items.tpall.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpall.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpall.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tpall.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.tp.items.tppos.item_name").replace("&", "§"))) {
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tppos.infos.1").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tppos.infos.2").replace("&", "§"));
					player.sendMessage(main.getConfig().getString("help.gui.tp.items.tppos.infos.3").replace("&", "§"));
					player.closeInventory();
				}
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.items_multi.retour.item_name").replace("&", "§"))) {
					player.performCommand("help cmds");
				}
				if(itemStack.getType() == Material.BLACK_STAINED_GLASS_PANE) {
					event.setCancelled(true);
				}
			}
			if(event.getView().getTitle().equalsIgnoreCase(main.getConfig().getString("help.gui.reseaux.title").replace("&", "§").replace(">", "»"))) {
				if(itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(main.getConfig().getString("help.gui.reseaux.items.discord.item_name").replace("&", "§"))) {
					player.performCommand("discord");
					player.closeInventory();
				}
			}
		}
	}

}

import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ReplaceWordsTest {
	@Test
	public void test() {
		ReplaceWords r = new ReplaceWords();
		String res;

//		res = r.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery");
//		Assert.assertThat(res, CoreMatchers.equalTo("the cat was rat by the bat"));
//
//		res = r.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was cattle rattled by the battery");
//		Assert.assertThat(res, CoreMatchers.equalTo("the cat was cat rat by the bat"));
//
//		res = r.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was cattled rattled by the battery");
//		Assert.assertThat(res, CoreMatchers.equalTo("the cat was cat rat by the bat"));

		res = r.replaceWords(
				Arrays.asList("uxbiw", "pb", "zmeno", "bj", "tdjn", "fcomt", "rdd", "z", "d", "i", "gxmxj", "swga", "t", "g",
						"bjoz", "siyi", "fpp", "gpied", "qjf", "h", "dorm", "zd", "gx", "viczg", "dewq", "tz", "dwyxy", "o",
						"rtcq", "j"),
				"cfrbiqbqzveiczjn miwz hv uslvci vuhgzbulkiurzxkiqe nqg rccocvwfp sntmlrrdsqwpvem iyrw kbqwjkfichfrejx "
						+ "lhzylxmbptiwmn v nodg xijddmenifxaffhxxx hpltrapstesvkrnjoqdl mygwsjmgzzoixyo xcnyhbmpkpamtzdrjls "
						+ "wtuddincttwfnai cgxlvdww yqhnapyzkv nmrvpd poimszzov epmiddarizx tlhkwz pqq ardwiezm iowkiammwm "
						+ "ewlotixpfsbhkwphaiv ehitgi eczvbyheauzvho");
		Assert.assertThat(res, CoreMatchers.equalTo(
				"cfrbiqbqzveiczjn miwz h uslvci vuhgzbulkiurzxkiqe nqg rccocvwfp sntmlrrdsqwpvem i kbqwjkfichfrejx "
						+ "lhzylxmbptiwmn v nodg xijddmenifxaffhxxx h mygwsjmgzzoixyo xcnyhbmpkpamtzdrjls wtuddincttwfnai "
						+ "cgxlvdww yqhnapyzkv nmrvpd poimszzov epmiddarizx t pqq ardwiezm i ewlotixpfsbhkwphaiv ehitgi "
						+ "eczvbyheauzvho"));

		res = r.replaceWords(
				Arrays.asList("bqum", "dyccm", "enjbor", "ucjck", "ruhqff", "qtqqjaf", "sux", "stjqh", "tilvgno", "ljuxvof",
						"pip", "arwvwz", "ccdf", "fconiukv", "yrsslnwo", "yjxy", "deejt", "oemjbg", "syqqcpow", "mjmi",
						"pxqnqvje", "qfgd", "rmhjtj", "tttxcj", "xaeclsji", "noezki", "rwnzxp", "knicrcr", "phuuya", "bbdbsh",
						"alqwor", "fcuipqm", "vpe", "nyupge", "gpbm", "wcmtbayu", "xswpnk", "kety", "xpmdke", "uhgriwi", "asu",
						"mbf", "flccmpzx", "wtglzo", "qydm", "xrplf", "dxl", "ljee", "mhfx", "nij", "pdczkbia", "egjaov",
						"jcbtlb", "jbb", "fckqcjub", "fwu", "laie", "mmlutl", "iahwokol", "mfhibko", "uwatxry", "wczzt", "mjrtn",
						"woxjm", "ins", "gwsai", "cdxorq", "xfy", "uzsjk", "cgczfd", "mktupl", "dvgsnrtw", "mdowr", "tnylv",
						"akewp", "uwtdckg", "nhe", "jznax", "ndhxh", "jto", "gvy", "vuvwmzq", "otyd", "nwkbros", "cuztmw",
						"yvvtvf", "vuqn", "ehjospy", "jnc", "sie", "mpbo", "rkgiy", "lcf", "xdqxqsm", "yeqeip", "ybafxpxd",
						"inzrzgw", "komf", "feqcn", "quxhsl"),
				"gioqujdqvf mphrpnzlu cocrrf jnxsfhmimtacvoywbffr iagrgfnkugkdnkz cndfdzkhwdeythfp ua pgjitcygbpsejny "
						+ "lffgcnr qwrcux sqifyzgkbgkdjqbmy awfohwmmbvzu xfxctl jtcbboxdhxfxrbrniaqk lxkdevf mubobc "
						+ "fmdyhiksmwolj fqfilsckzwqyip f ilnajedufkciqdgc ofxwycsf ufy kduadaxeptctlnrxs vhhlw "
						+ "wyowykidjjqi s dlndqxakelowvnspxer jxdghmniyw ilpxmipqmaygdwtmer nphonooy flj ogusvnnzucinquu"
						+ " cvjpxhyjsrxid yjzhw wghsdflltsjkmsc ckwsyw epwuhgeevvc qhy qowsfkddceklmaktaj "
						+ "smsspyopdibqkzjkpgjy vusnjicayeowdv qltktfhdfi sprcndsgtniyoigts bx epyelknmphjvkbjesfaz "
						+ "pipdjnvebarjpobza ue q urhfbtzruuqbca ndiqxxazyakpfe gcfordxaz czxnnuqfpbkjcxv nonkmghpxvyhr "
						+ "nwnnbttnoio ejkb pwwqqbyrf pz gejenqjkewug npivccuoklhtxulgp uqrh rbzuyjhyjzyoqrb "
						+ "uohkizufoawxbhbxxvpd nhoycstexfivggr occwowxjwhxtnfim pfdnlsnltaoiykr uozvcqjs "
						+ "zopyibfopkphrumvgd byacqluvmopfl oal daxhjlhumzvlgpxqctuj jct lmkysxgk nyevhrdiaiea "
						+ "flmtfmkjyf expokiuhwryeevhm bbsv srgpksxsoqguyyhrmyy dszgejq gtgwqvvtojn udbau pmavxyhoasyv "
						+ "ooudlxs bcjqkljkisjrnuvan sdutlauwdcopmvhmtepp msvxusiblcmgzbcjhe sqoylmmbsexlrspws zdzoiphk "
						+ "yszgacql dmpgwmcgfgtlaoeihi garvuq puxpkrongawlyqug qitwcgkahmgalz kiunuttlteofc jcziiw "
						+ "ecyqbfdbcjkbbvglwb xueqhtgwp aebsbsgayuizduk fisjeubcqxxiphklququ kkyacvywdjrsle ckd");
		Assert.assertThat(res, CoreMatchers.equalTo(
				"gioqujdqvf mphrpnzlu cocrrf jnxsfhmimtacvoywbffr iagrgfnkugkdnkz cndfdzkhwdeythfp ua pgjitcygbpsejny lffgcnr "
						+ "qwrcux sqifyzgkbgkdjqbmy awfohwmmbvzu xfxctl jtcbboxdhxfxrbrniaqk lxkdevf mubobc fmdyhiksmwolj "
						+ "fqfilsckzwqyip f ilnajedufkciqdgc ofxwycsf ufy kduadaxeptctlnrxs vhhlw wyowykidjjqi s "
						+ "dlndqxakelowvnspxer jxdghmniyw ilpxmipqmaygdwtmer nphonooy flj ogusvnnzucinquu cvjpxhyjsrxid yjzhw "
						+ "wghsdflltsjkmsc ckwsyw epwuhgeevvc qhy qowsfkddceklmaktaj smsspyopdibqkzjkpgjy vusnjicayeowdv "
						+ "qltktfhdfi sprcndsgtniyoigts bx epyelknmphjvkbjesfaz pip ue q urhfbtzruuqbca ndiqxxazyakpfe gcfordxaz"
						+ " czxnnuqfpbkjcxv nonkmghpxvyhr nwnnbttnoio ejkb pwwqqbyrf pz gejenqjkewug npivccuoklhtxulgp uqrh "
						+ "rbzuyjhyjzyoqrb uohkizufoawxbhbxxvpd nhoycstexfivggr occwowxjwhxtnfim pfdnlsnltaoiykr uozvcqjs "
						+ "zopyibfopkphrumvgd byacqluvmopfl oal daxhjlhumzvlgpxqctuj jct lmkysxgk nyevhrdiaiea flmtfmkjyf "
						+ "expokiuhwryeevhm bbsv srgpksxsoqguyyhrmyy dszgejq gtgwqvvtojn udbau pmavxyhoasyv ooudlxs "
						+ "bcjqkljkisjrnuvan sdutlauwdcopmvhmtepp msvxusiblcmgzbcjhe sqoylmmbsexlrspws zdzoiphk yszgacql "
						+ "dmpgwmcgfgtlaoeihi garvuq puxpkrongawlyqug qitwcgkahmgalz kiunuttlteofc jcziiw ecyqbfdbcjkbbvglwb "
						+ "xueqhtgwp aebsbsgayuizduk fisjeubcqxxiphklququ kkyacvywdjrsle ckd"));
	}
}
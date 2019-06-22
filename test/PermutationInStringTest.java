import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class PermutationInStringTest {
	@Test
	public void test() {
		PermutationInString p = new PermutationInString();
		boolean result;
		result = p.checkInclusion(
				"kuzntqeuvaszrspkgjvxrupwxwrexztptsowceibeewxbslvosbobmyymikdscshybtmanuxeqtanrjekbwirmhgvfmzipfiqxcilarfyasoayepgfzmdytlpjymeaztsyubkbmblepwozffxiitdhwaquozlfmnascomqczrbhxcnzugppddtudxrigfeaozzojpeamnobapgwksudbiwdedvprwonmzardsodhxmkgghqzfhorjaijdvwzsnfpdfklwibbsnwqsoajcpjisbgizgttlnmclawbgnhbmtcpuusuammvgxnopdngclxumgfgwjrinamevhirpmlkwtyxkrmoffrreotdosjghsrkgxyiyrytbbofgczndgmdalyvvoljczcztxitxelywqemjigtuanubpstndwzvtiejtoqvetaehvcuujyupncumjnkesmoadzyvkwvjqgqewvvvpheyyvkewefbjjqzajxnhouodanyruqpzdcjmgnxkmhsgqjhpcyviewmrkfioudzqivmmguxjxuxdmpsmkwnvbxcomifgxqmcovlkooptjpfxjllwtlkkoaayzduodgsusaogswmoqkznynwiukkrrxzkwcknwlazxnlmghybxmyvquzbdqlpfydhnnuvlmyjmixyzso",
				"zthosfejqodcstlqczkndmgwtcakxzxaklkrehkfwnokclametzpnblcwaspdblfoopsiqrpzlbmlysddlqxcjzezcpknwzljvhmqxqinmptcppipifchxexlytleambzwmqwgvxlehnecdqsqbrxqfwvcovgdvtmwbnvajvkizixbmuiuyuixjhiohimghdbohetogrhzsbzgpekosxcjglsrvzenovpjyzknuumpsdrufcjsyfbuwfmaaztxjbpjctnuwcqknnemptjbgfthyafeatskfmysaioqikcpywmefujnvthumyhareltknxyvqprexgbwyzodfkinltwobeukrmpyjkrgvwhbtnzaozgxouxndmkyvzlujhxxwebptykctbojgnvcwhhgsyohccrqxksdyygcwdsazlznhqjdddisjmfqvjqcquuvjrzkcvzpxpfakbkrqlzacanqbggavezedqmoffxmkrlcwxdeosvhvvknqimwpasrlldewvhppzixgcxisysgeppcwfknecupyrrqnkhvessintrequaqiuoesgyndovaqxnlldmdupjcjzejannfjfasguyvgsdakwxezrginhdstbrtqmznpkasytqtbfyftwhgnuazcwehsvcdukuifmkefzabxyhihgnldpsvglubalbsvqstfxehvnpxmrejnkqacafuvzghbttgqmjhqzejasoasbpjirfawcvwahykvrfpaadcgvxssebdznzyvamyilahahgdslwvpuvzsinbbqecdqyvwnucjzyxmxwqwyxbxoljnjcqqdumghmcvqpcpjlxemupospxvkicqvyiavatbojgzurfzitgpeqjmvsgzzqphciyweyavebslgegjcyqmgehchryyclswjequeijzpsvuercqzhwgtgyxhxavhqkrwqdvkqvklicxpasnsnbgybtufdgbwrpaewzwczabckvddtewunsktcznqkivsubdjrpzxtsohiilcybrwqtlfqmjzmvpbfjmbjvbpwietkyzwzizwuiohjuhoekejhmkrooeyydmavdencmxhsxdnyitzivlymzyqogdhzrwhbdupborzqihurziajjwbrfwkzgbpmfgtobkbzyijcgkszyuyouyxvztmmtaqetcaxqrkbrmkzyokglckifgdfidjqoiqrfrpftagxxoqodbyygdioxdznycssxjvpotsrptttrbjayhugecptuibezsyggqcyvzosvmlpwmnuhovvhfyazkdrfxlxjxpbkkbuexxnklhnkteyjshhlojnbxtyltdfzhulcsptinpsskaeowofruejqpinhivlpvvosppxtbbrebvfihmamdlvsjirwfzhzmaqzuryakjlzroxrlwccdannvzwenabvosplnwhotxyzxhocdnvsekmnepzzqjhqrokocqewpihhyftshsfehijlvpajrcrgeqqjigmzkrhcgafqkdkrkkyausijdfzqewawxurtzhioqqnoxhbrdrriveapdebbwbrnmpcakomfhpfrqvzmpqkqucoepjklaqtirgkcrgpdhvyxybnulrchqgbupjdxxalbwljfpdjfnlqfquhdxvvuaecgzgfhulhkkvpuexpssodxqxhrbpzzgdiohxzjxnuhtavlittooxkuededfxdaabuzdlwjhitwykqdvtrwuohpvpgpeudhpslpvxmotibojtgvohqaaowiofdtgbkiiurhcfavlgsnqxndcxyxozklduxqeovzrtwuhoikgpyqoqwllagzufkuzntqeuvaszrspkgjvxrupwxwrexztptsowceibeewxbslvosbobmyymikdscshybtmanuxeqtanrjekbwirmhgvfmzipfiqxcilarfyfsoayepgfzmdytlpjymeaztsyubkbmblepwozffxiitdhwaquozlfmnascomqczrbhxcnzugppddtudxrigfeaozzojpeamnobapgwksudbmwdedvprwonmzardsodhxmkgghqzfhorjaijdvwzsnfpdfklwibbsnwqsoajcpjisbgizgttlnmclawbgnhbmtcpuusuamivgxnopdngclxumgfgwjrinamevhirpmlkwtyxkrmoafrreotdosjghsrkgxyiyrytbbofgczndgmdalyvvoljczcztxitxelywqemjigtuanubpstndwzvtiejtoqvetaehvcuujyupncumjnkesmoadzyvkwvjqgqewvvvpheyyvkewefbjjqzajxnhouodanyruqpzdcjmgnxkmhsgqjhpcyviewmrkfioudzqivmmguxjxuxdmpsmkwnvbxcomifgxqmcovlkooptjpfxjllwtlkkoaayzduodgsusaogswmoqkznynyiukkrrxzkwcknwlazxnlmghybxmyvquzbdqlpfydhnnuvlmyjmixwzsoufvjlrqtzxvybzhurdqdtnkciiradptqxzgrkqgfbnsmptyyggwpenatlrtpvmdpveivmenzwjlwdhlhmmpvbglhxcinvhhcphgklicwwnwqbkbndiuqowwgzdczwvlazndbboublzrltxahxenivmkbwofrnkkvjixfbbctshvqzmgwqrmheupodlrnebsidrbxxjfeoqgcoscymzskvbamtxtpumbdmedjghxazwamkqdrxsqytqxkrrqcnwrtkuaocuwmyucctdnaqfjlosovveoxjyypqrbkflxrrxlnjxhkrrvjettqfzzbwbzowsufxmppazhwiwcvimmlixdzgpmfayrblbkulfopwarxlsbfkuqvhyufwdswfpxqwhuvepyslbliapotofrxhufoopqhqjcjdtleeoedsacpeqfewxehghwvfvqmlzvzudkqxinsfekpbaggbpohbtbhcvdzvuormpzadkhhqqyspfkijjcelofwgkgimjxrkwqwhpqfihyhmwdkwhathcxvxtuopufsjaagbamghtsjewrpooxrprtvqpslsbaijrzojgwhekijtfugwbvgdltgpentcyjbwqjcdqkhicbsdvgtvsecpsacesztkjdskoumcheqzmoijoimnmnhfavttfamkkvugpmnibdzhcieyhhctifhbvqrllslpvymjamfmgladmpeqdrtumbqwcwwkduavjokhjrdbdozxaqemvurjwdukuwrbzfstuesjqfgblvvaqemylqgrtfzdrfgtcbvaokygyidfsbppasppzcunjwbrhqscumnrugeyxqvceninwsvmqcekvuetloevkrntgsrivpebgoobcggmgwkrzagkdavpejdgkpokcdpvncsmduzhowhdjklqwyphevtaugcabxovxgjovvgzksukpnadsblbpnuuihxdkovwsmniptwhrjxhyitozdwgkdkasspklxbyfmmugmawjflmrdiqmolsufpyzkrrqrvgnbtcogomdjrymxgnocnmpsdmbncterfrrxqyrsdqjzrodttnjbblleexyvfzxemlxfmxbzffflpyifrqhbdnwpuuwfhskfevjshsxvhvbldqyxenpxkvamashnbmrfiladqnuzwltrkoegwxrjveajpyvchyotakniwcyigejnaspdfjssacnfhbyobgrovavxoclvkgvgivoiycquftjuqynabeqakugedwlogqfbbivbzisljreuowaxfaugjunbyrcxvlqjvvuewgprwfiofxyzdaomzjfystxrbpmgdwyznnuzibozcjtsxxastlhmjpogvuhdtfhnmrhdxihhrtxqocmsmysxuudsdquadshqncpbejkjarbhkwkstpcqgwuarnmvtfjvdzeeklwnnjdewmwdyzdfnryaqoiysysfvlxetggjhywxwvkvvuccklxptokzvrrhodicekjrffbdjxoftxbstcbxjcksqcvcwkisywdzepzgznaorlllmahrqepouqnrtbhgxnsnyhkacxhjzgvxhlukbvspfzqgguqkngncotvgvuygijtkucvqcsjjolodnbfeznuikkaghyyqtxmtdjchrgybirzkbysbgnwwqaxjsnneazxnmdyzooizcyqtxlmqvujoqhjqlnuvojlkcdybfryidsunirmymtvltnjiggwxeqowcnbukotbngjaidyvhmobdxlklwqxshkaphxwdxzonqddvstwrrtatklpujldtgrofxyunlmlwquruzekmdymzhpuuuaiyinmaedxxhhayzybsepcohcrymkysdaeagmhodvkoissnegjecmtnbydbakamurdqwwgqqfbefltdkdvyldjxynweicudbwirebvzknodfkycidoqaalxorwlvnosvcpudvsiljwlmfqpvwtbjeyydexvfmkiilwlxcpnogyeyspjaumcbrgxkeeezgyrbmtkotoyjnedraupxevwjcluyxdctfazusyqeklxpotczvkphllcgfrykpuwscfknqhfkxdihdkymiqizppipnbflfhduzjgvoehhvtqolybcshofasguaaeaakcsxqsqxpuydzhndleoxgmkrtlivudapfhefocneliicmrtishcmxmcdskyedbqppswqnesziwankobhaxklswulygdojhpobyezjzyengtfulymybqiodmkirqpggycyouzqhrexnntvnlhhokdyzvudgilvqpjkeactaivsjdwfesruusewlpscumpqslulwrhramanthuogjdadmqjeccbutdfexdcsbqujpqdlryelnzvfbncrajicdnomidvmspjljjzglnahdmrctedjzdtozllmmyeamctrcyrzzdzwvfqgjfstbtitgmeogjpgllpihylxgupxxqmheusrglbampwrhtejoqqjkcljmppmemguapopatjkbzomwegkrwxblxgymfmurhfokjkhljtxosxtgmaldrjjhxrcvuddvzlamavxpzszsrfepfsukadtnwyzhwdergrofmetngzuifiuonziduvucichmxhmxrulpykwedymiycbhcsvrkctvqqfvygtlyhlqbrwvmbgnwlryeotjkvowxmdlyjhyvtvyognldmsxqlotfzvxrmdultwbsnstmjakjaqqpfurvwturqyzcnfkoxumuquwgpersslowdvrnssqcgwmfnssvtobdwcscoikoythwhsxswsmsimntribaohzrmjculdnnguchmqgyzqeipuumwgizlvjmpvyotgzmtsantswdarbyaklpiclafgqdaoeiitxlcpwhlqsidkb");
		Assert.assertThat(result, CoreMatchers.equalTo(true));

		result = p.checkInclusion(
				"jqowgtqdokaxwlqdhfvyxnaflcxinzmwptndasfcllrucjvixufbcdrwcxbjmvwmjzjcqnugddugkaqbirmthedbfidisueqruimmvetezyzjvyqzucdlrlicqldmtsrluhphqrwejqbcgafhqxfxceibvshmvdjubdinoeqlitgnhvjvbqwcvdhncxognwoaeyojayyrzbokaxsihhkzbkvaczlmepzhlwnyzdzborlwbhicmdyieiwarxwpzgukknkplhmkciolicttdsbesbkysnpwhhqmpdctfqyawxxbrjmgbefhuajwedaingmrwfdptobbkfxgupczsahmxngmupbolysndbgswzlxldjynxrooiszcfyhixupcgudalteszwwkrhipqmxckzxydftkoxsmemggcedizgqihcjnbnjaduhucwoxarpachkqmnhafddyhaoqkeskodukkgnnejjskykgwfnoyspcjgvnbjmxdnpvxjbwqkokzchcvddbuzgtbackxevisusequrqwrsmeqbffcfzzzdqvreeydfygkmkzftzgbkjznqqdpzanpojqhrrghmnmmjsgxnozjnieuffbsvtxzizwhhtcrszyjwlmbxklakzhymzvpuuywpqksiuifkshzsdsnsgdbpmgvinihwykzzpoojukgltdcvncerrmxkrnqrmslchvlarghbnqgdtyfrwsuhhodymsrpxgqptjlvhmlcazvvybuljbpaqqqqdcufkqgcknrlrwzbdtqqykdwrqputjxortexovmtpmeyogxxcykxpbknbrjvwgfdrjmrwxutbwzcialjnbokhddaonxfoqaxarkzslcwqorlhdpsbryswboxftjjbmvlvstzfgmvvltbziyflrddkyxslifvcunyxrmbhadolsebrumwcjlkzfpncweynspxpftcbahdwjlmaxyvigxubjgoimyqtxqiajidfmajgpkqpcznuafehnkznydfxuvfucngrxksggapliibymejxzcmbdrfbzdjxyzblphmkhqluqtviuzixhgwqqueeckurttbsssykhsexmqqtfeicpjckvsgrmcwayjpshkltnqapjbbhhihlalzeuddrmodkeofemhzgqwiyoygpajbqpscuzpzsprkyobbtypegbqbnodpiuwptxgvmizxcgcocqymcranquqnwggwjbcskwjvvnpfmhaohrhuzmfgskufilqstxinwdockopciyuaaeoqdappvlfzklqlpjrkaeigtlfvjcfuxlazrxnqupcnlkyqwfkyhpvnirltoxrckanedkezyekbiolscaqltwxpoybxrspmamjmdmjfflxeokelpsavsdvhqqbwtopsfkijdzsygkoinqwhufwnbgauiprsitlapkllaipwbdbzettoxmfddynxhrujwcouxgtrjemrxmceaatfxomyqyqjpiwducxpuyailvgiuxrzoonydokcymdgqzbuanzdxufcftqremdcrbyspoylvcqvyoyxhsbvlpamysyqltiwnsicvatgmztrmicpsedldlhylellpmqvhymryfhkbkdytdqlonsuzyqsimlsfxbdffpcziviwxfiraaoepadarqpldxecydtcogbpnuugbendyvxgpybhqzwgussybomxzdmmrvysqimxxyjqrvjwjjivwywdqmsgkgdzhpaahpanxkzqbhtjqdgjcybnufpwutuafdzegslokejhfwrrdmlyitegckpzyipmyhsdpukrgbduoifxqikvlahjkicjhtofiufnjdanzhtomtxswwcljezreipjlpkzmpkisklxanpdzzetfzecdjinacsuilnejspdqihzlbshvqfnycfwgcgzbmmpiwrwtrpnmkiegdahhttlqvxqbnqpbqyxkaslgxvwsyjyuahenadpmfinwdzcudgkjfwkahjs",
				"deasvrgsdxhdbemwpenmbhjbnykuygxvmfkjagxnjoywjdgmjewtofmbpfehbfgauiihajsdbarllcmoqkqvebwvtitjqscqnantzpqtifwvmzlnkyuxoruhqlvvoqqdwzccprqmsrllrzfyvqgiyrbqlmskrqjdfdvygtsmijcqdhmpuqhrmsrwzsnnxpynjtechsxvlwhurtqbieshuragietmcokwxrlvehihspodjkkpweqekrjemnsimexuktmoqiowiyifqjsylmmejuhltwjfqfyyujuwdivyzctvrkefdzpwqrzpembtrcamzubewkanmgnmfjyatgnkxtmimnqsodgvnbkowvjebslcfdrqjkpjhfqojwtdfunhctckgipwgmtlzialllhcnarbbrtxgzddmryuohmjtsnpkkpvtipqjkucuqnqgdvvsquedghikbayosxjfwrvlnjpukbxhzruatdiwemwjnjpkwancvdniwiefcstdgyhycntmgroneylurnehnhjqjqomcgcwprwdoejlvaponqhyaultpxqvykydofkpurzqhygxmieyjotxhiqtvlnmffxurxhmrhvdkkgwaekojxocoofvznjynlzhbojbkljzhihfepmhuirqxsxjslbaoilykltzpqzjzvoqenjuayqmktpsoedxnwwibotpjgpmpfsnbipuammzlaogvekhzftqxrbmiwuhynpaznoqsxfiuacwogolvqvzbqlmunaemsvhlmtkavbzvhdignnhdziydpqaizjlytqjrhgtbdaxmgepysvtnampnldgpgtrbhtzhfbvclwustztaerkzggiekheckfquleawilaexocaggnxeygovsfzkjkeizfkfcffdrgzcftjlaluooqkgceoahlhwvfmwwkgqiqxstlzahtyzicnyboeqstdskkidqcseyrjfsucvyefbkikfjzesdpoxkhstiapcidwxaantpxzjxuipkzcrybgftemljmdaeisvfrnlrzlbbxukiggchmpriytsdqlzbjsgrfffwiwdupgjkudtemkncffcxxdeqepqcbmcfurwbjhsyvjxlzittwsodkgnfsklbzdclcsireusuzfraqmjrhbtyrnogsfllnjbxwicpsshhgiqgdnlvzybzdkgpngyylznhxaktgmiriqrfsigowybnrdfhwbknjpwqwrvcmvxpfqpburfglokymmwjshsjrdzlcxzmpwefyqwgjvvjlejhpcfvdfnlbyuvwdsoihailxypsoswpfauxdbaqukclmqikmimiryeptmygvkvmcjkkswthokvksoibotyrsprajrjucvukekiuyjnydiwaqpelrxadrhruhqoxhowbabtfwaxlvqbzpghijvbkxqqgmdksecjymvtrqqgycvmqjbdypphvfkhrfbnkxyyxkguxpdjvndwpihdtlvarfxveltnvmmdufihhqttmbpoyzwhieoblwjaoxbhmvmbklpuprlvqthmdskyixgcspiawdeoopxhzpsdtxsfjzrkdvnbtmbehjqowgtqdokaxwlqdhfvyxnaflcxinzmwptndasfclnrucjvixufbcdrwcxbjmvwmjzjcqnhgddugkaqqirmthedbfidisueqruimmvetezyzjvyqzucdlrlfaqldmtsrluhphqrwejqbcgafhqxfxceibvshmvdjubdinoeqlitgnhvjvbqwcvdhncxognwoaeyojayyrzmokpxsihhkzbkvaczlmepzhlwnyzdzborlwbhicmduieiwarxwpzgukknkplhmkcioficttdsbesbkysnpwhhqmpdctfqyawxxbrjmgbefhuajwedaingmrwfdptobbkfxgupczsahmxngmupbolysndbgswzlxldjynxrooiszcfyhixupcgudalteszwwkrhipqmxckzxydftkoxsmemggcxhizgqihcjnbnjaduhucwoxarpachkqmnhafddyhaoqkeskodukkgnnejjskykgwfnoyspcjgvnbjmxdnpvxjbwqkokzchcvddbuzgtbackxevisusequrqwrsmeqbffcfzzzdqvreeydfygkmkzftzgbkjznqqdpzanpojqhrrghmnmmjsgxnozjnieuffbsvtxzizwhhtcrszyjwlmbxklakzhymzvpuuywpqksauifkshzsdsnsgdbpmgvinihwykzzpoojukgltdcvncerrmxkrnqrmslchvlarghbnqgdtyfrwsuhhodymsrpxgqptjlvhmlcazvvybuljbpaqqqqdculkqgckdrlrwzbdtqqykdwrqputjxortexovmtpmeyogxxcykxpbknbrjvwgfdrjmrwxutbwzcijnjnbokhddaonxfoqaxarkzslcwqorlhdvsbryswboxftjjbmvlvstzfgmvvltbziyflrddkyxslifvcunyxrmbradolsebrumwcjlkzfpncweynspxpftcbahdwjlmaxyvigxubjgoimyqtxqiajidfmajgpkqpcznuafetnkznydfxuvfucngrxksggapliibymejxzcmbdrfbzdjxyzblphmkhqlubtviuzixhgwqqueeckurttbsssykhsexmqqtfeicpjckvsgrbcwayjpshkltnqapjbbhhinlalzeuddrmodkeofemhzgqweyoygpajbqpscuzpzsprkyobbtypegbqbnodpiuwptxgvmizxcgcocqymcranquqnwggwjbcskwjvvnpfmhaohhhuzmfgskufilqstxinwdockopciyuaaeoqdappvlfzklqlpjrkaeigdlfvjcfuxlazrxnqupcnlkyqwfkyhpvnirltoxrckanedkezyekbiolscaqltwxpoybxrspmamjmdmafflxeokelpsavsdvhqqbwtopsfkijdzsygkoihqwhyfwnbgauiprsitlapkllaipwbdbzettoxmfddynxhrujwcouxgtrjemrxmciaatfxomyqyqjpiwducepuyailvgiuxrzoonydokcymdgqzbuanzdxufcftqremdcrbyspoylvcqvyoyxhsbvlpamysyqltiwnsicvatgmztrmicpsedldlhylellpmqvhymryfhkbkdytdqlonsuzyqsimlsfxbdffpcziviwxfiraaoepadarqpldxecydtcogbpnuugbendyvxgpybhqzwgussybomxzdmmrvysqimxxyjqrpjwjjivwywdqmsgkgdzhpaahpalxkzqbhtjqdgjcybnufpwutuafdzegslokejhfwrrdmlyitegckpzyipmyhsdpukrgbduoiixqikvlahjkicjutofiufnjdanzhtomtxswwcljezreipjlpkzmpkisklxanidzzetfzecljinacsuilnejspdqihzlbshvqfnycfwgcgzbmmpiwrwtrpnmkiegdchhttlqvxqbnqpbqyxkaslgxvwsyjyuahenadpmfinwdzcudgkjfwkahjsyerluvhlmudkshnvhqygjxpfvblelciwbkiflnutrihyffamtmtnklexvvelsoyjypppvflbeoxorlfmhryxcvyeypxdtailsnfiuqapwhrovfrhkeqpzeysxhqyjpihbdnqpshyemgpxcnscfzgydmemuffryevsjxdcbynebxnhvfwpnhmmxzubjkmqkecmoqtugbxdwowcawjmqlmwjlwmaxftpdnprgxekkusmzuythqmqtacbyepvoickldankkssjyfpxqmabqorvtpgztuqyjgqjhmzmqnuyrfgjkrgoimnbhkzhoefscczbejgkjtztwwcsmalbezdtxihbyimigmotxuftbszrnquyvuxacdrwnzmstkxujwjcmmqmbennupqzvjgxgyrbttudkpprljznpjhadlavgzisehircbdnxmltfsmbffppszjtekdfeagpquf");
		Assert.assertThat(result, CoreMatchers.equalTo(true));
	}
}
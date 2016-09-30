package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class EmailProvider extends FromJsonProvider<EmailProvider.EmailRecord[]> {

    private EmailProvider(Class<EmailRecord[]> clazz) {
        super(clazz);
    }

    @Override
    protected String json() {
        return "[\n" +
                "  {\n" +
                "    \"userName\": \"rgibson0\",\n" +
                "    \"domainName\": \"paginegialle.it\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"tfox1\",\n" +
                "    \"domainName\": \"globo.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"smorgan2\",\n" +
                "    \"domainName\": \"addtoany.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"hburke3\",\n" +
                "    \"domainName\": \"imdb.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"cmartinez4\",\n" +
                "    \"domainName\": \"addtoany.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"wblack5\",\n" +
                "    \"domainName\": \"psu.edu\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"jgonzales6\",\n" +
                "    \"domainName\": \"webmd.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"ksimpson7\",\n" +
                "    \"domainName\": \"google.pl\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"eberry8\",\n" +
                "    \"domainName\": \"zimbio.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"cnelson9\",\n" +
                "    \"domainName\": \"berkeley.edu\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"jlopeza\",\n" +
                "    \"domainName\": \"smugmug.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"dandrewsb\",\n" +
                "    \"domainName\": \"theatlantic.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"khughesc\",\n" +
                "    \"domainName\": \"mayoclinic.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"wlopezd\",\n" +
                "    \"domainName\": \"patch.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"adixone\",\n" +
                "    \"domainName\": \"ow.ly\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"sburkef\",\n" +
                "    \"domainName\": \"woothemes.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"rreedg\",\n" +
                "    \"domainName\": \"barnesandnoble.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"sgreenh\",\n" +
                "    \"domainName\": \"nymag.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"gkelleyi\",\n" +
                "    \"domainName\": \"ted.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"kwatsonj\",\n" +
                "    \"domainName\": \"foxnews.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"tfosterk\",\n" +
                "    \"domainName\": \"ifeng.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"hclarkl\",\n" +
                "    \"domainName\": \"prweb.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"randersonm\",\n" +
                "    \"domainName\": \"ed.gov\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"rlanen\",\n" +
                "    \"domainName\": \"latimes.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"iperkinso\",\n" +
                "    \"domainName\": \"taobao.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"jadamsp\",\n" +
                "    \"domainName\": \"loc.gov\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"mbowmanq\",\n" +
                "    \"domainName\": \"indiegogo.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"fallenr\",\n" +
                "    \"domainName\": \"java.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"rreeds\",\n" +
                "    \"domainName\": \"wisc.edu\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"kcartert\",\n" +
                "    \"domainName\": \"yelp.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"emartinezu\",\n" +
                "    \"domainName\": \"mayoclinic.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"jfosterv\",\n" +
                "    \"domainName\": \"amazon.de\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"mcampbellw\",\n" +
                "    \"domainName\": \"cafepress.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"dhansonx\",\n" +
                "    \"domainName\": \"spiegel.de\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"nlongy\",\n" +
                "    \"domainName\": \"cmu.edu\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"ldanielsz\",\n" +
                "    \"domainName\": \"netvibes.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"bmartin12\",\n" +
                "    \"domainName\": \"nih.gov\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"nmcdonald13\",\n" +
                "    \"domainName\": \"netvibes.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"cpalmer14\",\n" +
                "    \"domainName\": \"reference.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"padams15\",\n" +
                "    \"domainName\": \"buzzfeed.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"bdixon16\",\n" +
                "    \"domainName\": \"meetup.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"awilliamson17\",\n" +
                "    \"domainName\": \"issuu.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"gryan18\",\n" +
                "    \"domainName\": \"github.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"bscott19\",\n" +
                "    \"domainName\": \"sohu.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"khicks1a\",\n" +
                "    \"domainName\": \"hugedomains.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"jfrazier1b\",\n" +
                "    \"domainName\": \"friendfeed.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"fgreen1c\",\n" +
                "    \"domainName\": \"addthis.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"jmorgan1d\",\n" +
                "    \"domainName\": \"shutterfly.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"abryant1e\",\n" +
                "    \"domainName\": \"edublogs.org\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"lowens1f\",\n" +
                "    \"domainName\": \"i2i.jp\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"vtorres1g\",\n" +
                "    \"domainName\": \"cafepress.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"sross1h\",\n" +
                "    \"domainName\": \"yellowpages.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"pfowler1j\",\n" +
                "    \"domainName\": \"hc360.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"paustin1k\",\n" +
                "    \"domainName\": \"unicef.org\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"pfernandez1l\",\n" +
                "    \"domainName\": \"samsung.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"kbrown1m\",\n" +
                "    \"domainName\": \"cbc.ca\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"emontgomery1n\",\n" +
                "    \"domainName\": \"apple.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"smills1o\",\n" +
                "    \"domainName\": \"barnesandnoble.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"slong1p\",\n" +
                "    \"domainName\": \"hud.gov\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"jmartinez1q\",\n" +
                "    \"domainName\": \"imgur.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"wcollins1r\",\n" +
                "    \"domainName\": \"amazonaws.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"phill1s\",\n" +
                "    \"domainName\": \"forbes.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"thart1u\",\n" +
                "    \"domainName\": \"google.it\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"rfuller1v\",\n" +
                "    \"domainName\": \"xing.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"mnguyen1w\",\n" +
                "    \"domainName\": \"cbsnews.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"rgonzalez1x\",\n" +
                "    \"domainName\": \"liveinternet.ru\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"nmcdonald1y\",\n" +
                "    \"domainName\": \"lulu.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"bwilson20\",\n" +
                "    \"domainName\": \"newsvine.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"hhudson21\",\n" +
                "    \"domainName\": \"time.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"danderson23\",\n" +
                "    \"domainName\": \"addtoany.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"srodriguez24\",\n" +
                "    \"domainName\": \"gizmodo.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"jrussell25\",\n" +
                "    \"domainName\": \"sphinn.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"jwilliams26\",\n" +
                "    \"domainName\": \"barnesandnoble.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"kdunn27\",\n" +
                "    \"domainName\": \"vistaprint.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"smatthews28\",\n" +
                "    \"domainName\": \"dot.gov\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"rdixon29\",\n" +
                "    \"domainName\": \"lulu.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"mharper2a\",\n" +
                "    \"domainName\": \"wired.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"rdiaz2b\",\n" +
                "    \"domainName\": \"sourceforge.net\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"rmontgomery2c\",\n" +
                "    \"domainName\": \"taobao.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"rfisher2d\",\n" +
                "    \"domainName\": \"ibm.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"lgilbert2e\",\n" +
                "    \"domainName\": \"craigslist.org\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"swebb2f\",\n" +
                "    \"domainName\": \"cbsnews.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"rcrawford2g\",\n" +
                "    \"domainName\": \"dropbox.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"dcruz2h\",\n" +
                "    \"domainName\": \"yahoo.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"pferguson2i\",\n" +
                "    \"domainName\": \"tripod.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"skelley2j\",\n" +
                "    \"domainName\": \"wordpress.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"cmartinez2k\",\n" +
                "    \"domainName\": \"indiegogo.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"janderson2l\",\n" +
                "    \"domainName\": \"pbs.org\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"dhernandez2m\",\n" +
                "    \"domainName\": \"ameblo.jp\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"ereyes2o\",\n" +
                "    \"domainName\": \"google.fr\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"jhill2p\",\n" +
                "    \"domainName\": \"hexun.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"vdavis2q\",\n" +
                "    \"domainName\": \"mayoclinic.com\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userName\": \"enguyen2r\",\n" +
                "    \"domainName\": \"pbs.org\"\n" +
                "  }\n" +
                "]";
    }

    public static class EmailRecord {
        public String userName;
        public String domainName;
    }
}

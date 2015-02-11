mvn war:war;mvn ear:ear;mkdir target/war; mv target/kqco_mult_web_front-01.war target/war; jar -xvf target/war/kqco_mult_web_front-01.war target/war;
#rm target/war/kqco_mult_web_front-01.war;rm -f target/war/WEB-INF/lib/org.eclipse*.jar;rm -f target/war/WEB-INF/lib/jetty*.jar;jar -cvf kqco_mult_web_front-01.war .;mkdir target/ear;mv target/kqco-mult_web-front-01.ear ear;jar -xvf target/ear/kqco-mult_web-front01.ear; 


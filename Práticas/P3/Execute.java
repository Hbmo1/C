@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      System.out.println("Olá " + ctx.ID().getText());
      return null;
   }

   @Override public String visitFarewell(HelloParser.FarewellContext ctx) {
      System.out.println("Olá " + ctx.ID().getText());
      return null;
   }
}

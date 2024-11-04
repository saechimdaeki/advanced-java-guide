package network.tcp.autocloseable;

public class ResourceCloseMainV4 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");

            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable : suppressed) {
                System.out.println("suppressedEx : " + throwable);
            }

            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        try (ResourceV2 resourceV1 = new ResourceV2("resource1");
             ResourceV2 resourceV2 = new ResourceV2("resource2")) {

            resourceV1.call();
            resourceV2.callEx(); // CallException 발생

        } catch (CallException e) {
            System.out.println("ex : " + e);
            throw e;
        }
    }
}

package com.lesson02.ioc;

class IoCService {
    public void serve() {
        System.out.println("Service is serving");
    }
}

class IoCClient {
    private IoCService ioCService;

    public IoCClient(IoCService service) {
        this.ioCService = service;
    }

    public void doSomething() {
        ioCService.serve();
    }
}

public class IoCWithDI {
    public static void main(String[] args) {
        IoCService service = new IoCService();
        IoCClient client = new IoCClient(service);
        client.doSomething();
    }
}

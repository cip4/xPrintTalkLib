
package org.cip4.lib.xprinttalk.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.cip4.lib.xprinttalk.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Cancellation_QNAME = new QName("http://www.printtalk.org/schema_2_0", "Cancellation");
    private final static QName _ProofApprovalResponse_QNAME = new QName("http://www.printtalk.org/schema_2_0", "ProofApprovalResponse");
    private final static QName _PurchaseOrder_QNAME = new QName("http://www.printtalk.org/schema_2_0", "PurchaseOrder");
    private final static QName _OrderStatusResponse_QNAME = new QName("http://www.printtalk.org/schema_2_0", "OrderStatusResponse");
    private final static QName _Quote_QNAME = new QName("http://www.printtalk.org/schema_2_0", "Quote");
    private final static QName _OrderStatusRequest_QNAME = new QName("http://www.printtalk.org/schema_2_0", "OrderStatusRequest");
    private final static QName _Refusal_QNAME = new QName("http://www.printtalk.org/schema_2_0", "Refusal");
    private final static QName _RFQ_QNAME = new QName("http://www.printtalk.org/schema_2_0", "RFQ");
    private final static QName _ProofApprovalRequest_QNAME = new QName("http://www.printtalk.org/schema_2_0", "ProofApprovalRequest");
    private final static QName _BusinessObject_QNAME = new QName("http://www.printtalk.org/schema_2_0", "BusinessObject");
    private final static QName _Confirmation_QNAME = new QName("http://www.printtalk.org/schema_2_0", "Confirmation");
    private final static QName _Quotation_QNAME = new QName("http://www.printtalk.org/schema_2_0", "Quotation");
    private final static QName _Invoice_QNAME = new QName("http://www.printtalk.org/schema_2_0", "Invoice");
    private final static QName _ReturnJob_QNAME = new QName("http://www.printtalk.org/schema_2_0", "ReturnJob");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.cip4.lib.xprinttalk.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Refusal }
     * 
     */
    public Refusal createRefusal() {
        return new Refusal();
    }

    /**
     * Create an instance of {@link To }
     * 
     */
    public To createTo() {
        return new To();
    }

    /**
     * Create an instance of {@link ReturnJob }
     * 
     */
    public ReturnJob createReturnJob() {
        return new ReturnJob();
    }

    /**
     * Create an instance of {@link Confirmation }
     * 
     */
    public Confirmation createConfirmation() {
        return new Confirmation();
    }

    /**
     * Create an instance of {@link QuoteType }
     * 
     */
    public QuoteType createQuoteType() {
        return new QuoteType();
    }

    /**
     * Create an instance of {@link CXMLUserAgent }
     * 
     */
    public CXMLUserAgent createCXMLUserAgent() {
        return new CXMLUserAgent();
    }

    /**
     * Create an instance of {@link StatusRequest }
     * 
     */
    public StatusRequest createStatusRequest() {
        return new StatusRequest();
    }

    /**
     * Create an instance of {@link Cancellation }
     * 
     */
    public Cancellation createCancellation() {
        return new Cancellation();
    }

    /**
     * Create an instance of {@link CXMLTextOnly }
     * 
     */
    public CXMLTextOnly createCXMLTextOnly() {
        return new CXMLTextOnly();
    }

    /**
     * Create an instance of {@link PrintTalk }
     * 
     */
    public PrintTalk createPrintTalk() {
        return new PrintTalk();
    }

    /**
     * Create an instance of {@link Sender }
     * 
     */
    public Sender createSender() {
        return new Sender();
    }

    /**
     * Create an instance of {@link CXMLCredentialMac }
     * 
     */
    public CXMLCredentialMac createCXMLCredentialMac() {
        return new CXMLCredentialMac();
    }

    /**
     * Create an instance of {@link ProofApprovalResponse }
     * 
     */
    public ProofApprovalResponse createProofApprovalResponse() {
        return new ProofApprovalResponse();
    }

    /**
     * Create an instance of {@link From }
     * 
     */
    public From createFrom() {
        return new From();
    }

    /**
     * Create an instance of {@link ProofRequest }
     * 
     */
    public ProofRequest createProofRequest() {
        return new ProofRequest();
    }

    /**
     * Create an instance of {@link Invoice }
     * 
     */
    public Invoice createInvoice() {
        return new Invoice();
    }

    /**
     * Create an instance of {@link Additional }
     * 
     */
    public Additional createAdditional() {
        return new Additional();
    }

    /**
     * Create an instance of {@link Pricing }
     * 
     */
    public Pricing createPricing() {
        return new Pricing();
    }

    /**
     * Create an instance of {@link Price }
     * 
     */
    public Price createPrice() {
        return new Price();
    }

    /**
     * Create an instance of {@link OrderStatusRequest }
     * 
     */
    public OrderStatusRequest createOrderStatusRequest() {
        return new OrderStatusRequest();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link ProofResponse }
     * 
     */
    public ProofResponse createProofResponse() {
        return new ProofResponse();
    }

    /**
     * Create an instance of {@link CreditCard }
     * 
     */
    public CreditCard createCreditCard() {
        return new CreditCard();
    }

    /**
     * Create an instance of {@link OrderStatusResponse }
     * 
     */
    public OrderStatusResponse createOrderStatusResponse() {
        return new OrderStatusResponse();
    }

    /**
     * Create an instance of {@link ProofApprovalRequest }
     * 
     */
    public ProofApprovalRequest createProofApprovalRequest() {
        return new ProofApprovalRequest();
    }

    /**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link Quotation }
     * 
     */
    public Quotation createQuotation() {
        return new Quotation();
    }

    /**
     * Create an instance of {@link CXMLSharedSecret }
     * 
     */
    public CXMLSharedSecret createCXMLSharedSecret() {
        return new CXMLSharedSecret();
    }

    /**
     * Create an instance of {@link Credential }
     * 
     */
    public Credential createCredential() {
        return new Credential();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link RFQ }
     * 
     */
    public RFQ createRFQ() {
        return new RFQ();
    }

    /**
     * Create an instance of {@link PurchaseOrder }
     * 
     */
    public PurchaseOrder createPurchaseOrder() {
        return new PurchaseOrder();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cancellation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "Cancellation", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<Cancellation> createCancellation(Cancellation value) {
        return new JAXBElement<Cancellation>(_Cancellation_QNAME, Cancellation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProofApprovalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "ProofApprovalResponse", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<ProofApprovalResponse> createProofApprovalResponse(ProofApprovalResponse value) {
        return new JAXBElement<ProofApprovalResponse>(_ProofApprovalResponse_QNAME, ProofApprovalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PurchaseOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "PurchaseOrder", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<PurchaseOrder> createPurchaseOrder(PurchaseOrder value) {
        return new JAXBElement<PurchaseOrder>(_PurchaseOrder_QNAME, PurchaseOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "OrderStatusResponse", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<OrderStatusResponse> createOrderStatusResponse(OrderStatusResponse value) {
        return new JAXBElement<OrderStatusResponse>(_OrderStatusResponse_QNAME, OrderStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Quotation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "Quote", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<Quotation> createQuote(Quotation value) {
        return new JAXBElement<Quotation>(_Quote_QNAME, Quotation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderStatusRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "OrderStatusRequest", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<OrderStatusRequest> createOrderStatusRequest(OrderStatusRequest value) {
        return new JAXBElement<OrderStatusRequest>(_OrderStatusRequest_QNAME, OrderStatusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Refusal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "Refusal", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<Refusal> createRefusal(Refusal value) {
        return new JAXBElement<Refusal>(_Refusal_QNAME, Refusal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RFQ }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "RFQ", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<RFQ> createRFQ(RFQ value) {
        return new JAXBElement<RFQ>(_RFQ_QNAME, RFQ.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProofApprovalRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "ProofApprovalRequest", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<ProofApprovalRequest> createProofApprovalRequest(ProofApprovalRequest value) {
        return new JAXBElement<ProofApprovalRequest>(_ProofApprovalRequest_QNAME, ProofApprovalRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusinessObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "BusinessObject")
    public JAXBElement<BusinessObject> createBusinessObject(BusinessObject value) {
        return new JAXBElement<BusinessObject>(_BusinessObject_QNAME, BusinessObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Confirmation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "Confirmation", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<Confirmation> createConfirmation(Confirmation value) {
        return new JAXBElement<Confirmation>(_Confirmation_QNAME, Confirmation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Quotation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "Quotation", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<Quotation> createQuotation(Quotation value) {
        return new JAXBElement<Quotation>(_Quotation_QNAME, Quotation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Invoice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "Invoice", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<Invoice> createInvoice(Invoice value) {
        return new JAXBElement<Invoice>(_Invoice_QNAME, Invoice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.printtalk.org/schema_2_0", name = "ReturnJob", substitutionHeadNamespace = "http://www.printtalk.org/schema_2_0", substitutionHeadName = "BusinessObject")
    public JAXBElement<ReturnJob> createReturnJob(ReturnJob value) {
        return new JAXBElement<ReturnJob>(_ReturnJob_QNAME, ReturnJob.class, null, value);
    }

}

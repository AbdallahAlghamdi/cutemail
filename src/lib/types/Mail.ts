interface Recipient{
  identifier: string
  name: string;
}
interface Mail {
    recipient:Recipient,
    sender: Recipient,
    id: number;
    read: boolean;
    subject: string;
    date: Date;
    attachment_count: number;
    content: string
  }

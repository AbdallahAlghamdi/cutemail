<script lang="ts">
  import ButtonIcon from "$lib/componets/ButtonIcon.svelte";
  import { onMount } from "svelte";
  import { SvelteSet } from "svelte/reactivity";

  let originalInbox = $state<Mail[]>([]);
  let inbox = $state<Mail[]>([]);
  let selection = $state(new SvelteSet<number>());
  let selected = $derived(selection.size > 1);

  onMount(() => {
    const dummy = [
      {
        id: 1111,
        read: true,
        sender: { identifier: "!", name: "Gargemi" },
        recipient: { identifier: "!", name: "Gargemi" },
        subject: "Your account has been flagged for deletion",
        date: new Date("2021-04-13T12:00:00.000+00:00"),
        attachment_count: 1,
        content: "",
      },
      {
        id: 1112,
        read: false,
        sender: { identifier: "♠", name: "Ahmed" },
        recipient: { identifier: "!", name: "Gargemi" },
        subject: "Have you seen the 'News'? What should we tell others?",
        date: new Date("2020-04-14T20:00:00.000+19:00"),
        attachment_count: 0,
        content: "",
      },
    ];
    dummy.forEach((mail) => inbox.push(mail));
    console.log(inbox.length);
  });

  function formatDate(date: Date) {
    const year = date.getFullYear().toString();
    const month = date.getMonth().toString();
    const day = date.getDate().toString();

    return day + "-" + month + "-" + year;
  }
</script>

<div class="mail pixelCheckbox">
  <section class="actions">
    <ButtonIcon
      onclick={() => {
        console.log("Selection: ", selection.size);
        console.log("selection", selection);
        inbox = inbox.filter((mail) => !selection.has(mail.id));
        selection.clear();
      }}
      src="icons/piiixl/ui/trashcan-open.png"
      title="delete selected email"
      alt="trash can"
    />
    <ButtonIcon
      onclick={() => {}}
      src="icons/piiixl/ui/floppy-disk.png"
      title="Save selected mail"
      alt="save"
    />
    <ButtonIcon
      onclick={() => {}}
      src="icons/piiixl/ui/compose.png"
      title="compose new mail"
      alt="new mail"
    />
    <ButtonIcon
      onclick={() => {
        inbox.map((mail) => {
          if (selection.has(mail.id)) mail.read = true;
        });
      }}
      src="icons/piiixl/ui/mail-set-read.png"
      title="set mail as read"
      alt="new mail"
    />
  </section>
  <div class="table">
    <table>
      <thead>
        <tr>
          <th title="Select/Deselect mail">
            <span class="selection">
              <input
                type="checkbox"
                bind:checked={selected}
                onclick={() => {
                  if (!inbox) return;
                  if (selection.size === inbox.length) selection.clear();
                  else inbox.forEach((mail) => selection.add(mail.id));
                }}
              />
              {selection.size}
            </span>
          </th>
          <th>Sender</th>
          <th class="subject">Subject</th>
          <th
            onclick={() => {
              inbox.sort((a, b) => a.date.getTime() - b.date.getTime());
            }}>Date</th
          >
          <th>
            <img
              src="icons/piiixl/ui/attachment.png"
              alt="attachment"
              title="shows the amount of attachments in the mail"
            />
          </th>
        </tr>
      </thead>
      <tbody>
        {#each inbox as mail (mail.id)}
          <tr>
            <td class="status">
              <input
                onclick={() => {
                  if (selection.has(mail.id)) selection.delete(mail.id);
                  else selection.add(mail.id);
                }}
                type="checkbox"
                checked={selection.has(mail.id)}
              />
              {#if mail.read}
                <img src="/icons/piiixl/ui/mail-open.png" alt="read mail" />
              {:else}
                <img src="/icons/piiixl/ui/mail-closed.png" alt="read mail" />
              {/if}
            </td>
            <td class="sender">
              <span>{mail.sender.identifier}</span>
              <span>{mail.sender.name}</span>
            </td>
            <td>{mail.subject}</td>
            <td class="date">{formatDate(mail.date)}</td>
            <td>{mail.attachment_count}</td>
          </tr>
        {/each}
      </tbody>
    </table>
  </div>
</div>

<!-- ♥ ♦ ♣ ♠ -->

<style>
  .selection {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 5px;
    width: 55px;
  }
  .sender {
    text-wrap: nowrap;
  }
  .date {
    text-wrap: nowrap;
  }
  .status {
    display: flex;
    align-items: center;
    gap: 5px;
  }

  .mail {
    overflow: hidden;
    display: flex;
    flex-direction: column;
    margin: 8px;
  }

  .subject {
    width: 100%;
    padding: 16px;
    text-wrap: pretty;
  }
  .table {
    flex-grow: 1;
    overflow: scroll;
    color: #303843;
  }
  th {
    color: white;
    padding: 5px;
  }

  thead tr {
    position: sticky;
    top: 0px;
    box-sizing: content-box;
    background-color: #442434;
    /* border: 20px black solid; */
    box-shadow:
      inset 0px 0px 0px 2px #442434,
      inset 0px 0px 0px 4px #e76a3a;

    /* font-weight: 900; */
  }

  td:last-child {
    text-align: center;
  }

  tbody tr:nth-child(even) {
    background-color: #f2b888;
  }

  td {
    cursor: url("icons/mayke_arth/cursor-06.png"), pointer;
    padding: 6px;
  }
</style>
